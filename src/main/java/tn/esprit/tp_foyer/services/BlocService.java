package tn.esprit.tp_foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.*;
import tn.esprit.tp_foyer.interfaces.IBlocService;
import tn.esprit.tp_foyer.repositories.BlocRepository;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class BlocService implements IBlocService {
    private final BlocRepository repo;

    @Override
    public Bloc getBloc(Long id) {
        return  repo.findById(id).orElse(new Bloc());
    }

    @Override
    public List<Bloc> getAllBloc() {
        return repo.findAll();
    }

    @Override
    public List<Bloc> getBlocsByCapaciteBloc(Long capaciteBlocAfter, Long capaciteBlocBefore) {
        return repo.getBlocsByCapaciteBlocGreaterThanOrCapaciteBlocLessThan(capaciteBlocAfter,capaciteBlocBefore);
    }

    @Override
    public Bloc createOrUpdate(Bloc b){ return repo.save(b); }                             // no setId(null)
    @Override
    public void delete(Long id){ repo.deleteById(id); }

    @Override
    public Bloc getBlocByChambreId(Long idChambre) {
        return repo.getBlocByChambreId(idChambre);
    }

}
