package tn.esprit.tp_foyer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Universite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;

    // 1 Universite -> 1 Foyer (owning side)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;
}
