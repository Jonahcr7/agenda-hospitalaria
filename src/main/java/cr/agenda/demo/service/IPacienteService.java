package cr.agenda.demo.service;

import cr.agenda.demo.dto.paciente.CreatePacienteRequest;
import cr.agenda.demo.dto.paciente.PacienteResponse;
import cr.agenda.demo.dto.paciente.UpdatePacienteRequest;

import java.util.List;

public interface IPacienteService {

    public List<PacienteResponse> listarPacientes();

    public List<PacienteResponse> listarPacientesActivos();

    public List<PacienteResponse> listarPacientesInactivos();

    public PacienteResponse buscarPacientePorId(Long id);

    public PacienteResponse crearPaciente(CreatePacienteRequest request);

    public PacienteResponse actualizarPaciente(Long id, UpdatePacienteRequest request);

    public  void eliminarPaciente(Long id);

}
