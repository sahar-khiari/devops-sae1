package tn.esprit.tp_foyer.interfaces;


import tn.esprit.tp_foyer.entity.Foyer;
import java.util.List;
import java.util.Optional;

public interface IFoyerService {
    List<Foyer> findAll();
    Optional<Foyer> findById(Long id);
    Foyer create(Foyer f);
    Foyer update(Long id, Foyer f);
    void delete(Long id);
    }
