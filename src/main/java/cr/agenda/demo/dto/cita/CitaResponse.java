package cr.agenda.demo.dto.cita;

import cr.agenda.demo.dto.medico.MedicoResponse;
import cr.agenda.demo.dto.paciente.PacienteResponse;
import cr.agenda.demo.model.Cita;
import cr.agenda.demo.model.enums.Estado;

import java.time.LocalDateTime;

public record CitaResponse(
        Long idCita,
        LocalDateTime fechaHora,
        String motivoConsulta,
        Estado estado,
        PacienteResponse paciente,
        MedicoResponse medicoResponse
) {
    public CitaResponse(Cita datos) {
        this(
                datos.getId(),
                datos.getFechaHora(),
                datos.getMotivoConsulta(),
                datos.getEstado(),
                new PacienteResponse(datos.getPaciente()),
                new MedicoResponse(datos.getMedico())
        );
    }
}
