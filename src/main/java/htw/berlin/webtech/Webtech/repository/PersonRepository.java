package htw.berlin.webtech.Webtech.repository;

import htw.berlin.webtech.Webtech.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
