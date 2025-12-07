package tn.esprit.tp_foyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Chambre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    // Plusieurs chambres dans 1 bloc
    @ManyToOne
    @JoinColumn(name = "bloc_id")
    @JsonIgnore
    private Bloc bloc;

    // 1 Chambre -> * Réservations
    @OneToMany( cascade = CascadeType.PERSIST)
    private List<Reservation> reservations;
}
