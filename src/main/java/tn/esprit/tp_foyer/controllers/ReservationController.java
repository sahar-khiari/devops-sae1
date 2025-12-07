package tn.esprit.tp_foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Reservation;
import tn.esprit.tp_foyer.interfaces.IReservationService;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService service;

    @GetMapping
    public List<Reservation> all(){ return service.findAll(); }
    @GetMapping("/{id}")  public Reservation one(@PathVariable String id){ return service.findById(id).orElse(null); }
    @PostMapping
    public Reservation create(@RequestBody Reservation u){ return service.create(u); }
    @PutMapping("/{id}")  public Reservation update(@PathVariable String id, @RequestBody Reservation u){ return service.update(id,u); }
    @DeleteMapping("/{id}") public void delete(@PathVariable String id){ service.delete(id); }
}
