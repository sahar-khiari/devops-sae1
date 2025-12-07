package tn.esprit.tp_foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.dto.FoyerDTO;
import tn.esprit.tp_foyer.dto.Mapper;
import tn.esprit.tp_foyer.dto.UniversiteDTO;
import tn.esprit.tp_foyer.entity.*;
import tn.esprit.tp_foyer.interfaces.IUniversiteService;
import tn.esprit.tp_foyer.repositories.*;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class UniversiteService implements IUniversiteService {
    private final UniversiteRepository uniRepo;
    private final FoyerRepository foyerRepo;
    private final Mapper mapper;
    public List<Universite> findAll(){ return uniRepo.findAll(); }
    public Optional<Universite> findById(Long id){ return uniRepo.findById(id); }
    public Universite create(Universite u) {
        u.setIdUniversite(null); // ensure it's a create

        if (u.getFoyer() != null && u.getFoyer().getIdFoyer() != null) {
            // Attach existing Foyer (managed reference, no DB hit until needed)
            Foyer managed = foyerRepo.getReferenceById(u.getFoyer().getIdFoyer());
            u.setFoyer(managed);
        }
        return uniRepo.save(u);
    }    public Universite update(Long id, Universite u){  return uniRepo.save(u); }
    public void delete(Long id){ uniRepo.deleteById(id); }

    @Override
    public UniversiteDTO affecterFoyerAUniversite(Long idFoyer, Long idUniversite) {
        Universite u = uniRepo.findById(idUniversite).get();
        Foyer f = foyerRepo.findById(idFoyer).get();
        u.setFoyer(f);
        Universite u1 = uniRepo.save(u);
//        UniversiteDTO universiteDTO = new UniversiteDTO();
//        universiteDTO.setIdUniversite(u1.getIdUniversite());
//        FoyerDTO foyerDTO = new FoyerDTO();
//        foyerDTO.setCapacite(u1.getFoyer().getCapaciteFoyer());
//        foyerDTO.setNom(u1.getFoyer().getNomFoyer());
//        universiteDTO.setFoyer(foyerDTO);
        return mapper.toDTO(u1) ;

    }



}

