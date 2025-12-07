package tn.esprit.tp_foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.interfaces.IFoyerService;
import java.util.List;

@RestController
@RequestMapping("/foyer")
@RequiredArgsConstructor
public class FoyerController {
    private final IFoyerService service;

    @GetMapping
    public List<Foyer> all(){ return service.findAll(); }
    @GetMapping("/{id}")  public Foyer one(@PathVariable Long id){ return service.findById(id).orElse(null); }
    @PostMapping
    public Foyer create(@RequestBody Foyer u){ return service.create(u); }
    @PutMapping("/{id}")  public Foyer update(@PathVariable Long id, @RequestBody Foyer u){ return service.update(id,u); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }

}
