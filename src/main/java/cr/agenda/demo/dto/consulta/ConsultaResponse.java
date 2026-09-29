package cr.agenda.demo.dto.consulta;

import cr.agenda.demo.dto.cita.CitaResponse;
import cr.agenda.demo.model.Consulta;

import java.time.LocalDateTime;

public record ConsultaResponse(
        Long idConsulta,
        LocalDateTime fechaHora,
        String sintomas,
        String diagnostico,
        String tratamiento,
        String observaciones,
        CitaResponse citaResponse
) {
    public ConsultaResponse(Consulta request) {
        this(
                request.getId(),
                request.getFechaHoraDeAtencion(),
                request.getSintomas(),
                request.getDiagnostico(),
                request.getTratamiento(),
                request.getObservaciones(),
                new CitaResponse(request.getCita())
        );
    }
}
