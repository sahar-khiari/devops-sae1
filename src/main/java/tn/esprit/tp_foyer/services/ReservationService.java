package tn.esprit.tp_foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Reservation;
import tn.esprit.tp_foyer.interfaces.IReservationService;
import tn.esprit.tp_foyer.repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {
    private final ReservationRepository repo;

    public List<Reservation> findAll(){ return repo.findAll(); }
    public Optional<Reservation> findById(String id){ return repo.findById(id); }
    public Reservation create(Reservation r){ return repo.save(r); }  // id fourni
    public Reservation update(String id, Reservation r){ r.setIdReservation(id); return repo.save(r); }
    public void delete(String id){ repo.deleteById(id); }
}
