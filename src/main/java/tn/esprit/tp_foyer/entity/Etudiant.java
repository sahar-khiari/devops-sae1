package tn.esprit.tp_foyer.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    // Many-to-Many avec Reservation (inverse side)
    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;
}
