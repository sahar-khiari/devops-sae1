package tn.esprit.tp_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.dto.UniversiteDTO;
import tn.esprit.tp_foyer.entity.*;

import java.util.Optional;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
//    public Optional<UniversiteDTO> findById(long id);
}