package htw.berlin.webtech.Webtech.registration.token;


import htw.berlin.webtech.Webtech.benutzerKonto.BenutzerKonto;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class ConfirmationToken {
    /* @GenericGenerator(
             name = "userSequenceGenerator",
             strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
             parameters = {
                     @org.hibernate.annotations.Parameter(name = "sequence_name", value = "userSequence"),
                     @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                     @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
             }
     )*/
    // @SequenceGenerator(
    //    name = "confirmation_token_sequence",
    //    sequenceName = "confirmation_token_sequence",
    //    allocationSize = 1
    //  )
    // @Id
    // @GeneratedValue(generator = "userSequenceGenerator")
    // @GeneratedValue(
    //      strategy = GenerationType.SEQUENCE,
    //      generator = "confirmation_token_sequence"
    // )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "expires_at")
    private LocalDateTime expiresAt;
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false,
            name = "benutzer_konto_id")
    private BenutzerKonto benutzerKonto;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             BenutzerKonto benutzerKonto) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.benutzerKonto = benutzerKonto;
    }

    public ConfirmationToken() {

    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public BenutzerKonto getBenutzerKonto() {
        return benutzerKonto;
    }

    @Override
    public String toString() {
        return "ConfirmationToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                ", confirmedAt=" + confirmedAt +
                ", benutzerKonto=" + benutzerKonto +
                '}';
    }
}
