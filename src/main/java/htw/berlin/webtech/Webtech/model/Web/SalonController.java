package htw.berlin.webtech.Webtech.model.Web;

import htw.berlin.webtech.Webtech.benutzerKonto.AuthenticationRequest;
import htw.berlin.webtech.Webtech.benutzerKonto.AuthenticationResponse;
import htw.berlin.webtech.Webtech.benutzerKonto.BenutzerKonto;
import htw.berlin.webtech.Webtech.model.Person;
import htw.berlin.webtech.Webtech.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SalonController {

    @Autowired
    SalonService salonService;

    @Autowired
    DaoAuthenticationProvider provider;

    @PostMapping("/api/v1/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            Authentication authentication = provider.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(), request.getPassword()
            ));
            if (authentication.isAuthenticated()) {
                BenutzerKonto user = (BenutzerKonto) authentication.getPrincipal();
                AuthenticationResponse response = new AuthenticationResponse();
                response.setId(user.getId());
                response.setEmail(user.getEmail());
                response.setFirstName(user.getFirstName());
                response.setLastName(user.getLastName());
                response.setRolle(user.getRolle());
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

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