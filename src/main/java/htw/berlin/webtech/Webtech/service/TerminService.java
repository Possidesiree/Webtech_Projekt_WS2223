package htw.berlin.webtech.Webtech.service;

import htw.berlin.webtech.Webtech.model.Termin;
import htw.berlin.webtech.Webtech.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminService {
    @Autowired
    TerminRepository terminRepository;

    public Termin save(Termin termin) {
        return terminRepository.save(termin);
    }


    /*public Termin terminSpeichern(Termin termin) {
        return terminRepository.save(termin);
    }

    public List<Termin> findAll() {
        List<Termin> termin = terminRepository.findAll();
        return new ArrayList<>(termin);
    }

    public List<Termin> findById(Long id) {
        var termineId = terminRepository.findById(id);
        return termineId;

    }*/
}
