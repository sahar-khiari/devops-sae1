package tn.esprit.tp_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entity.*;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {}