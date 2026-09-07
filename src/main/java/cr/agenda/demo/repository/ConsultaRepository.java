package cr.agenda.demo.repository;

import cr.agenda.demo.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Optional<Consulta> findByCitaId(Long citaId);

    boolean existsByCitaId(Long citaId);
}
