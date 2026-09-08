package cr.agenda.demo.dto.medico;

import cr.agenda.demo.model.enums.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateMedicoRequest(
        String nombre,
        String apellido,
        @Email String email,
        String telefono,
        Especialidad especialidad
) {
}
