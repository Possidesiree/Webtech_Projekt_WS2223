package htw.berlin.webtech.Webtech.model.Web;

import htw.berlin.webtech.Webtech.benutzerKonto.BenutzerKonto;
import htw.berlin.webtech.Webtech.benutzerKonto.BenutzerKontoRepository;
import htw.berlin.webtech.Webtech.model.Termin;
import htw.berlin.webtech.Webtech.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(produces = "application/json")
public class TerminController {

    @Autowired
    TerminService terminService;

    @Autowired
    BenutzerKontoRepository benutzerKontoRepository;

    @PostMapping("api/v1/salon/termin")
    public ResponseEntity<TerminResponse> saveTermin(@RequestBody TerminRequest request) {
        BenutzerKonto user = benutzerKontoRepository.findById(request.getId()).orElseThrow();
        int random = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
        Termin termin = new Termin();
        termin.setDatetime(request.getDatetime());
        termin.setLeistung(request.getLeistung());
        termin.setKunde(user);
        termin.setReservierungsnummer(String.valueOf(random));

        terminService.save(termin);

        return ResponseEntity.ok(new TerminResponse(random));
    }


   /* @PostMapping("/neuerTerminForm")
    public String terminSpeichern(@ModelAttribute Termin termin, Model model) {
        termin = terminService.terminSpeichern(termin);
        model.addAttribute("termin", termin);
        return "termin";
    }*/
}
