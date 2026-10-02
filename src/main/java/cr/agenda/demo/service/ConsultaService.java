package cr.agenda.demo.service;

import cr.agenda.demo.dto.consulta.ConsultaResponse;
import cr.agenda.demo.dto.consulta.CreateConsultaRequest;
import cr.agenda.demo.dto.consulta.UpdateConsultaRequest;
import cr.agenda.demo.exception.RecursoNoEncontradoException;
import cr.agenda.demo.model.Cita;
import cr.agenda.demo.model.Consulta;
import cr.agenda.demo.model.enums.Estado;
import cr.agenda.demo.repository.CitaRepository;
import cr.agenda.demo.repository.ConsultaRepository;
import cr.agenda.demo.repository.MedicoRepository;
import cr.agenda.demo.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService implements IConsultaService {

    private final ConsultaRepository consultaRepository;
    private final CitaRepository citaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository  pacienteRepository;

    @Override
    public List<ConsultaResponse> mostrarConsultas() {
        return consultaRepository.findAll().stream().map(ConsultaResponse::new).toList();
    }

    @Override
    public ConsultaResponse buscarConsultaById(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Consulta no encontrada"));
        return new ConsultaResponse(consulta);
    }

    @Transactional
    @Override
    public ConsultaResponse crearConsulta(CreateConsultaRequest request) {
        Cita cita = citaRepository.findById(request.idCita()).
                orElseThrow(() -> new RecursoNoEncontradoException("Cita no encontrada"));
        if (!medicoRepository.existsByIdAndActivoTrue(cita.getMedico().getId()))
            throw new RecursoNoEncontradoException("Medico no encontrado/activo");
        if (!pacienteRepository.existsByIdAndActivoTrue(cita.getPaciente().getId()))
            throw new RecursoNoEncontradoException("Paciente no encontrado/activo");
        cita.setEstado(Estado.COMPLETADA);
        Consulta consulta = new Consulta(request,  cita);
        consultaRepository.save(consulta);
        return new ConsultaResponse(consulta);
    }

    @Transactional
    @Override
    public ConsultaResponse actualizarConsulta(Long id, UpdateConsultaRequest request) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Consulta no encontrada"));
        consulta.actualizarConsulta(request);
        return new ConsultaResponse(consulta);
    }

    @Transactional
    @Override
    public void eliminarConsulta(Long id) {
        boolean existe = consultaRepository.existsById(id);
        if (!existe)
            throw new RecursoNoEncontradoException("Consulta no encontrada");
        consultaRepository.deleteById(id);
    }
}
