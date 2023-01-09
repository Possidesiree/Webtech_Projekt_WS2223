package htw.berlin.webtech.Webtech.model.Web;

import com.fasterxml.jackson.annotation.JsonProperty;
import htw.berlin.webtech.Webtech.model.Leistung;

import java.time.LocalDateTime;

public class TerminRequest {

    @JsonProperty("userId")
    private Long id;
    private LocalDateTime datetime;
    private Leistung leistung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Leistung getLeistung() {
        return leistung;
    }

    public void setLeistung(Leistung leistung) {
        this.leistung = leistung;
    }
}
