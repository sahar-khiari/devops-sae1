package tn.esprit.tp_foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Etudiant;
import tn.esprit.tp_foyer.interfaces.IEtudiantService;
import tn.esprit.tp_foyer.repositories.EtudiantRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantService implements IEtudiantService {
    private final EtudiantRepository repo;

    public List<Etudiant> findAll(){ return repo.findAll(); }
    public Optional<Etudiant> findById(Long id){ return repo.findById(id); }
    public Etudiant create(Etudiant e){  return repo.save(e); }
    public Etudiant update(Long id, Etudiant e){ e.setIdEtudiant(id); return repo.save(e); }
    public void delete(Long id){ repo.deleteById(id); }
}
