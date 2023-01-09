package htw.berlin.webtech.Webtech.model;

import htw.berlin.webtech.Webtech.benutzerKonto.BenutzerKonto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "datetime")
    private LocalDateTime datetime;
    @Enumerated(EnumType.STRING)
    private Leistung leistung;
    @ManyToOne
    @JoinColumn(name = "kunden_id")
    private BenutzerKonto kunde;
    @Column(name = "reservierungs_nummer")
    private String reservierungsnummer;

    public Termin() {
        //Dummy Konstruktor

    }

    public Long getId() {
        return id;
    }

    public Leistung getLeistung() {
        return leistung;
    }

    public void setLeistung(Leistung leistung) {
        this.leistung = leistung;
    }

    public BenutzerKonto getKunde() {
        return kunde;
    }

    public void setKunde(BenutzerKonto kunde) {
        this.kunde = kunde;
    }

    public String getReservierungsnummer() {
        return reservierungsnummer;
    }

    public void setReservierungsnummer(String reservierungsnummer) {
        this.reservierungsnummer = reservierungsnummer;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Termin{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", leistung=" + leistung +
                ", reservierungsnummer=" + reservierungsnummer +
                ", kunde=" + kunde +
                '}';
    }
}


