package htw.berlin.webtech.Webtech.benutzerKonto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface BenutzerKontoRepository extends JpaRepository<BenutzerKonto, Long> {


    Optional<BenutzerKonto> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE BenutzerKonto a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
