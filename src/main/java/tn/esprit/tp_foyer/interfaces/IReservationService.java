package tn.esprit.tp_foyer.interfaces;


import tn.esprit.tp_foyer.entity.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    List<Reservation> findAll();
    Optional<Reservation> findById(String id);
    Reservation create(Reservation r);          // id fourni côté client
    Reservation update(String id, Reservation r);
    void delete(String id);
}
