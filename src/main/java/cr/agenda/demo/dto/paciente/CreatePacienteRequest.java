package cr.agenda.demo.dto.paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreatePacienteRequest(
        @NotBlank String nombre,
        String apellido,
        @Email String email,
        @NotBlank String telefono,
        LocalDate fechaNacimiento,
        @NotBlank String documentoIdentidad
) {
}
