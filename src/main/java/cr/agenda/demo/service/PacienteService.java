package cr.agenda.demo.service;

import cr.agenda.demo.dto.paciente.CreatePacienteRequest;
import cr.agenda.demo.dto.paciente.PacienteResponse;
import cr.agenda.demo.dto.paciente.UpdatePacienteRequest;
import cr.agenda.demo.exception.RecursoNoEncontradoException;
import cr.agenda.demo.model.Paciente;
import cr.agenda.demo.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService implements IPacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public List<PacienteResponse> listarPacientes() {
        return pacienteRepository.findAll().stream().map(PacienteResponse::new).toList();
    }

    @Override
    public List<PacienteResponse> listarPacientesActivos() {
        return pacienteRepository.findByActivo(true).stream().map(PacienteResponse::new).toList();
    }

    @Override
    public List<PacienteResponse> listarPacientesInactivos() {
        return pacienteRepository.findByActivo(false).stream().map(PacienteResponse::new).toList();
    }

    @Override
    public PacienteResponse buscarPacientePorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Paciente no encontrado"));
        return new PacienteResponse(paciente);
    }

    @Transactional
    @Override
    public PacienteResponse crearPaciente(CreatePacienteRequest request) {
        Paciente paciente = new Paciente(request);
        pacienteRepository.save(paciente);
        return new PacienteResponse(paciente);
    }

    @Transactional
    @Override
    public PacienteResponse actualizarPaciente(Long id, UpdatePacienteRequest request) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Paciente no encontrado"));
        paciente.actualizarPaciente(request);
        return new PacienteResponse(paciente);
    }

    @Transactional
    @Override
    public void eliminarPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id).
                orElseThrow(() -> new RecursoNoEncontradoException("Paciente no encontrado"));
        paciente.setActivo(false);
    }
}
