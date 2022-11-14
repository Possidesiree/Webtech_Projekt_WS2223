package htw.berlin.webtech.Webtech.model;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", nullable = false)
    private Long id;
    //@Column(name = "name", nullable = false)
    private String name;
    //@Column(name = "adresse", nullable = false)
    private String adresse;
    // @Column(name = "email", nullable = false)
    private String email;
    // @Column(name = "rolle", nullable = false)
    @Enumerated(EnumType.STRING)
    private Rolle rolle;

    public Person() {
        //Dummy Konstruktor
    }

    public Person(String name, String adresse, String email, Rolle rolle) {
        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.rolle = rolle;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", rolle=" + rolle +
                '}';
    }
}
