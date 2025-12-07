package tn.esprit.tp_foyer.interfaces;

import tn.esprit.tp_foyer.dto.FoyerDTO;
import tn.esprit.tp_foyer.dto.UniversiteDTO;
import tn.esprit.tp_foyer.entity.*;
import java.util.List;
import java.util.Optional;

public interface IUniversiteService {
    List<Universite> findAll();
    Optional<Universite> findById(Long id);
    Universite create(Universite u);
    Universite update(Long id, Universite u);
    void delete(Long id);
    UniversiteDTO affecterFoyerAUniversite(Long idFoyer, Long idUniversite);
}