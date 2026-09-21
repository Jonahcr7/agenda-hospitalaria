package cr.agenda.demo.dto.paciente;

import cr.agenda.demo.model.Paciente;

import java.time.LocalDate;

public record PacienteResponse(
        Long id,
        String nombre,
        String apellido,
        String telefono,
        LocalDate fechaNacimiento
) {
    public PacienteResponse(Paciente paciente){
    this(
            paciente.getId(),
            paciente.getNombre(),
            paciente.getApellido(),
            paciente.getTelefono(),
            paciente.getFechaNacimiento());
    }
}
