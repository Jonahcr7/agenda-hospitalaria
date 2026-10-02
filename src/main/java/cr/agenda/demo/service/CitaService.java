package cr.agenda.demo.service;

import cr.agenda.demo.dto.cita.CitaResponse;
import cr.agenda.demo.dto.cita.CreateCitaRequest;
import cr.agenda.demo.dto.cita.UpdateCitaRequest;
import cr.agenda.demo.exception.RecursoNoEncontradoException;
import cr.agenda.demo.model.Cita;
import cr.agenda.demo.model.Medico;
import cr.agenda.demo.model.Paciente;
import cr.agenda.demo.model.enums.Estado;
import cr.agenda.demo.repository.CitaRepository;
import cr.agenda.demo.repository.MedicoRepository;
import cr.agenda.demo.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService implements  ICitaService {

    private final CitaRepository citaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    @Override
    public List<CitaResponse> mostrarCitas() {
        return citaRepository.findAll().stream().map(CitaResponse::new).toList();
    }

    @Override
    public CitaResponse buscarCitaById(Long id) {
        Cita cita = citaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se encontró la cita con el ID ingresado"));
        return new CitaResponse(cita);
    }

    @Override
    public List<CitaResponse> buscarCitaByEstado(Estado estado) {
        return citaRepository.findByEstado(estado).stream().map(CitaResponse::new).toList();
    }

    @Transactional
    @Override
    public CitaResponse crearCita(CreateCitaRequest request) {
        if (!medicoRepository.existsByIdAndActivoTrue(request.idMedico()))
            throw new RecursoNoEncontradoException("Medico no encontrado/activo");
        if (!pacienteRepository.existsByIdAndActivoTrue(request.idPaciente()))
            throw new RecursoNoEncontradoException("Paciente no encontrado/activo");
        Medico medico = medicoRepository.getReferenceById(request.idMedico());
        Paciente paciente = pacienteRepository.getReferenceById(request.idPaciente());
        Cita cita = new Cita(request,  medico, paciente);
        citaRepository.save(cita);
        return new CitaResponse(cita);
    }

    @Transactional
    @Override
    public CitaResponse actualizarCita(Long id, UpdateCitaRequest request) {
        Cita cita = citaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Cita no encontrada"));
        if (!medicoRepository.existsByIdAndActivoTrue(request.idMedico()))
            throw new RecursoNoEncontradoException("Medico no encontrado/activo");
        Medico medico = medicoRepository.getReferenceById(request.idMedico());
        cita.actualizarCita(request, medico);
        return new CitaResponse(cita);
    }

    @Transactional
    @Override
    public void eliminarCita(Long id) {
        boolean existe = citaRepository.existsById(id);
        if (!existe)
            throw new RecursoNoEncontradoException("Cita no encontrada");
        citaRepository.deleteById(id);
    }
}
