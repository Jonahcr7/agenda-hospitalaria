package cr.agenda.demo.repository;

import cr.agenda.demo.dto.medico.MedicoResponse;
import cr.agenda.demo.model.Medico;
import cr.agenda.demo.model.enums.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Optional<Medico> findByCedula(String cedula);

    Optional<Medico> findByIdAndActivoTrue(Long id);

    boolean existsByIdAndActivoTrue(Long id);

    List<Medico> findByEspecialidad(Especialidad especialidad);

    List<Medico> findByActivo(boolean activo);
}
