package tn.esprit.tp_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entity.*;
import java.util.List;
@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> getBlocsByCapaciteBlocGreaterThanOrCapaciteBlocLessThan(Long capaciteBlocAfter, Long capaciteBlocBefore);
    List<Bloc> findByFoyerIdFoyer(Long foyerId);
    Bloc findByChambresIdChambre(Long chambreId);

    @Query("SELECT c.bloc FROM Chambre c WHERE c.idChambre = :idChambre")
    Bloc getBlocByChambreId(@Param("idChambre") Long idChambre);

}