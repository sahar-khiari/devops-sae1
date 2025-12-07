package tn.esprit.tp_foyer.dto;

import org.mapstruct.Mapping;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.entity.Universite;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    public UniversiteDTO toDTO(Universite universite);
    public Universite toEntity(UniversiteDTO universiteDTO);
    @Mapping(source = "nomFoyer",target = "nom")
    @Mapping(source = "capaciteFoyer",target = "capacite")
    public FoyerDTO toDTO(Foyer foyer);

}
