package tn.esprit.tp_foyer.interfaces;

import tn.esprit.tp_foyer.entity.*;
import java.util.List;
import java.util.Optional;


public interface IBlocService {
    Bloc getBloc(Long id);
    List<Bloc> getAllBloc();
    List<Bloc> getBlocsByCapaciteBloc(Long capaciteBlocAfter, Long capaciteBlocBefore);
     Bloc createOrUpdate(Bloc b);
    void delete(Long id);
    Bloc getBlocByChambreId(Long idChambre) ;


}