package cr.agenda.demo.dto.consulta;

import jakarta.validation.constraints.NotBlank;

public record UpdateConsultaRequest(
        @NotBlank String sintomas,
        @NotBlank String diagnostico,
        String tratamiento,
        String observaciones
) {
}
