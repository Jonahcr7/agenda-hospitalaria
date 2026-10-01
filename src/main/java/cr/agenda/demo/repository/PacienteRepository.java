package cr.agenda.demo.repository;

import cr.agenda.demo.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByDocumentoIdentidad(String documentoIdentidad);

    Optional<Paciente> findByIdAndActivoTrue(Long id);

    boolean existsByDocumentoIdentidad(String documentoIdentidad);

    List<Paciente> findByActivo(boolean activo);

}
