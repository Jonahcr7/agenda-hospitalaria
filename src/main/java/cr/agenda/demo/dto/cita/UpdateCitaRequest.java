package cr.agenda.demo.dto.cita;

import cr.agenda.demo.model.enums.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateCitaRequest(
        @NotNull Estado estado,
        @NotBlank String motivoConsulta,
        @NotNull Long idMedico
        ) {
}
