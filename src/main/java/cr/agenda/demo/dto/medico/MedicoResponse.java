package cr.agenda.demo.dto.medico;

import cr.agenda.demo.model.Medico;
import cr.agenda.demo.model.enums.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoResponse(
        String nombre,
        String apellido,
        String cedula,
        String email,
        String telefono,
        Especialidad especialidad
) {
    public MedicoResponse(Medico medico) {
        this(
                medico.getNombre(),
                medico.getApellido(),
                medico.getCedula(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad()
        );
    }
}
