package tn.esprit.tp_foyer.interfaces;


import tn.esprit.tp_foyer.entity.Etudiant;
import java.util.List;
import java.util.Optional;

public interface IEtudiantService {
    List<Etudiant> findAll();
    Optional<Etudiant> findById(Long id);
    Etudiant create(Etudiant e);
    Etudiant update(Long id, Etudiant e);
    void delete(Long id);
}
