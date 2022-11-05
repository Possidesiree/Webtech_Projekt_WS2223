package htw.berlin.webtech.Webtech.model;

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
    @JoinColumn(name = "mitarbeiter_id")
    private Person mitarbeiter;
    @ManyToOne
    @JoinColumn(name = "kunden_id")
    private Person kunde;

    public Termin() {
        //Dummy Konstruktor
    }

    public Termin(LocalDateTime buchungszeit, Leistung leistung, Person mitarbeiter, Person kunde) {
        this.buchungszeit = buchungszeit;
        this.leistung = leistung;
        this.mitarbeiter = mitarbeiter;
        this.kunde = kunde;
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

    public Person getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(Person mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public Person getKunde() {
        return kunde;
    }

    public void setKunde(Person kunde) {
        this.kunde = kunde;
    }

    @Override
    public String toString() {
        return "Termin{" +
                "id=" + id +
                ", buchungszeit=" + buchungszeit +
                ", leistung=" + leistung +
                ", mitarbeiter=" + mitarbeiter +
                ", kunde=" + kunde +
                '}';
    }
}


