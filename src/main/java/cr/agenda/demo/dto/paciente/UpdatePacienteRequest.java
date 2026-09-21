package cr.agenda.demo.dto.paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdatePacienteRequest(
        @NotBlank String nombre,
        String apellido,
        @Email String email,
        @NotBlank String telefono
) {
}
