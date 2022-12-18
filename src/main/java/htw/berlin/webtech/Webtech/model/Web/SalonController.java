package htw.berlin.webtech.Webtech.model.Web;

import htw.berlin.webtech.Webtech.model.Person;
import htw.berlin.webtech.Webtech.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SalonController {

    @Autowired
    SalonService salonService;

    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(salonService.findAll());
    }

    @GetMapping("api/v1/salon/person/{id}")
    public String getPerson(Model model, @PathVariable("id") Long id) {
        Person person = salonService.getPersonById(id);
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("api/v1/salon/personForm")
    public String getPersonForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "personForm";
    }


    @PostMapping("/neuesPersonForm")
    public String personSpeichern(@ModelAttribute Person person, Model model) {
        person = salonService.personSpeichern(person);
        model.addAttribute("person", person);
        return "person";
    }

}