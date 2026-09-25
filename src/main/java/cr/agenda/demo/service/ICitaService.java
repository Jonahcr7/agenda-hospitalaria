package cr.agenda.demo.service;

import cr.agenda.demo.dto.cita.CitaResponse;
import cr.agenda.demo.dto.cita.CreateCitaRequest;
import cr.agenda.demo.dto.cita.UpdateCitaRequest;
import cr.agenda.demo.model.enums.Estado;

import java.util.List;

public interface ICitaService {

    public List<CitaResponse> mostrarCitas();

    public CitaResponse buscarCitaById(Long id);

    public List<CitaResponse> buscarCitaByEstado(Estado estado);

    public CitaResponse crearCita(CreateCitaRequest request);

    public CitaResponse actualizarCita(Long id, UpdateCitaRequest request);

    public void eliminarCita(Long id);
}
