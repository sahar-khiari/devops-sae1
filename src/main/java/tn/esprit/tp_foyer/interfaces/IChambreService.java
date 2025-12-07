package tn.esprit.tp_foyer.interfaces;

import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.entity.Bloc;
import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    public Chambre affecterBlocAChambre(long idBloc,long idChambre);

}
