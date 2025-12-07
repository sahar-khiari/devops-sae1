package tn.esprit.tp_foyer.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.interfaces.IChambreService;
import tn.esprit.tp_foyer.repositories.BlocRepository;
import tn.esprit.tp_foyer.repositories.ChambreRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {
    ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre affecterBlocAChambre(long idBloc, long idChambre) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        Chambre chambre = chambreRepository.findById(idChambre).get();
        chambre.setBloc(bloc);
        return chambreRepository.save(chambre);
    }
}