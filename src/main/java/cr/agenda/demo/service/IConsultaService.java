package cr.agenda.demo.service;

import cr.agenda.demo.dto.consulta.ConsultaResponse;
import cr.agenda.demo.dto.consulta.CreateConsultaRequest;
import cr.agenda.demo.dto.consulta.UpdateConsultaRequest;

import java.util.List;

public interface IConsultaService {

    public List<ConsultaResponse> mostrarConsultas();

    public ConsultaResponse buscarConsultaById(Long id);

    public ConsultaResponse crearConsulta(CreateConsultaRequest request);

    public ConsultaResponse actualizarConsulta(Long id, UpdateConsultaRequest request);

    public void eliminarConsulta(Long id);
}
