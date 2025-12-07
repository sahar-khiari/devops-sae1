package tn.esprit.tp_foyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bloc {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    // * Chambres dans un bloc
    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Chambre> chambres;

    // Plusieurs blocs appartiennent à 1 foyer
    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;
}
