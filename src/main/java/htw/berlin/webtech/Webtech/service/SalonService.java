package htw.berlin.webtech.Webtech.service;

import htw.berlin.webtech.Webtech.model.Person;
import htw.berlin.webtech.Webtech.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalonService {

    @Autowired
    PersonRepository personRepository;

    public Person getPersonById(Long id) {
        return personRepository.findById(id).get();
    }

    public Person personSpeichern(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        List<Person> persons = personRepository.findAll();
        return new ArrayList<>(persons);
    }

    public Optional<Person> findById(Long id) {
        var personEntity = personRepository.findById(id);
        return personEntity;

    }

    public boolean deleteById(Long id) {
        if (!personRepository.existsById(id)) {
            return false;
        }

        personRepository.deleteById(id);
        return true;
    }
}
