package tn.esprit.tp_foyer.dto;

import lombok.*;
import tn.esprit.tp_foyer.entity.Foyer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FoyerDTO {
    private String nom;
    private Long capacite;


}
