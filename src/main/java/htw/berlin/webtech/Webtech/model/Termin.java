package htw.berlin.webtech.Webtech.model;

import htw.berlin.webtech.Webtech.benutzerKonto.BenutzerKonto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "buchungs_zeit")
    private LocalDateTime buchungszeit;
    @Enumerated(EnumType.STRING)
    private Leistung leistung;
    @ManyToOne
    @JoinColumn(name = "kunden_id")
    private BenutzerKonto kunde;

    public Termin() {
        //Dummy Konstruktor
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getBuchungszeit() {
        return buchungszeit;
    }

    public void setBuchungszeit(LocalDateTime buchungszeit) {
        this.buchungszeit = buchungszeit;
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

    @Override
    public String toString() {
        return "Termin{" +
                "id=" + id +
                ", buchungszeit=" + buchungszeit +
                ", leistung=" + leistung +
                ", kunde=" + kunde +
                '}';
    }
}


