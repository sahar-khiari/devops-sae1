package tn.esprit.tp_foyer.dto;

import lombok.*;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.entity.Universite;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UniversiteDTO {
    private long idUniversite;
    private FoyerDTO foyer;


}
