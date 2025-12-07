package tn.esprit.tp_foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.interfaces.IFoyerService;
import tn.esprit.tp_foyer.repositories.FoyerRepository;
import tn.esprit.tp_foyer.repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoyerService implements IFoyerService {
    private final FoyerRepository repo;
    private final UniversiteRepository uniRepo;

    public List<Foyer> findAll(){ return repo.findAll(); }
    public Optional<Foyer> findById(Long id){ return repo.findById(id); }
    public Foyer create(Foyer f){ return repo.save(f); }
    public Foyer update(Long id, Foyer f){  return repo.save(f); }
    public void delete(Long id){ repo.deleteById(id); }
}
