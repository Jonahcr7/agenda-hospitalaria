package cr.agenda.demo.repository;

import cr.agenda.demo.model.Cita;
import cr.agenda.demo.model.enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    boolean existsByMedicoIdAndFechaHoraAndEstadoNot(Long medicoId, LocalDateTime fechaHora, Estado estado);

    boolean existsByPacienteIdAndFechaHoraAndEstadoNot(Long pacienteId, LocalDateTime fechaHora, Estado estado);

    List<Cita> findByMedicoId(Long medicoId);

    List<Cita> findByPacienteId(Long pacienteId);

    List<Cita> findByEstado(Estado estado);
}
