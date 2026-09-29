package cr.agenda.demo.dto.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateConsultaRequest(
        @NotNull LocalDateTime fechaHoraDeAtencion,
        @NotBlank String sintomas,
        @NotBlank String diagnostico,
        String tratamiento,
        String observaciones,
        @NotNull Long idCita
) {
}
