package htw.berlin.webtech.Webtech.service;

import htw.berlin.webtech.Webtech.model.Person;
import htw.berlin.webtech.Webtech.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}