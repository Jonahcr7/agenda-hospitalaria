package cr.agenda.demo.repository;

import cr.agenda.demo.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByDocumentoIdentidad(String documentoIdentidad);

    boolean existsByDocumentoIdentidad(String documentoIdentidad);

}
