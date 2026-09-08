package cr.agenda.demo.dto.medico;

import cr.agenda.demo.model.enums.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateMedicoRequest(
        @NotBlank String nombre,
        @NotBlank String apellido,
        @NotBlank String cedula,
        @Email String email,
        String telefono,
        @NotNull Especialidad especialidad
) { }
