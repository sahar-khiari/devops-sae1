package tn.esprit.tp_foyer.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Reservation {
    @Id
    private String idReservation;       // pas @GeneratedValue

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private boolean estValide;


    // Many-to-Many avec Etudiant
    @ManyToMany
    @JoinTable(
            name = "etudiant_reservation",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    private Set<Etudiant> etudiants;
}
