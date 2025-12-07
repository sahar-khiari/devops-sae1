package tn.esprit.tp_foyer.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Foyer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    // 1 Foyer -> * Blocs
    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bloc> blocs;

    // 1–1 avec Universite (inverse side)
    @OneToOne(mappedBy = "foyer")
    private Universite universite;
}
