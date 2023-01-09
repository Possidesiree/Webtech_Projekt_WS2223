package htw.berlin.webtech.Webtech.repository;

import htw.berlin.webtech.Webtech.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminRepository extends JpaRepository<Termin, Long> {
}
