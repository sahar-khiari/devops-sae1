package tn.esprit.tp_foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Etudiant;
import tn.esprit.tp_foyer.interfaces.IEtudiantService;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantController {
    private final IEtudiantService service;

    @GetMapping
    public List<Etudiant> all(){ return service.findAll(); }
    @GetMapping("/{id}")  public Etudiant one(@PathVariable Long id){ return service.findById(id).orElse(null); }
    @PostMapping
    public Etudiant create(@RequestBody Etudiant u){ return service.create(u); }
    @PutMapping("/{id}")  public Etudiant update(@PathVariable Long id, @RequestBody Etudiant u){ return service.update(id,u); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
