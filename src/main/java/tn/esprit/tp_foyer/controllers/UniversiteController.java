package tn.esprit.tp_foyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.dto.UniversiteDTO;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.interfaces.IUniversiteService;
import java.util.List;

@RestController
@RequestMapping("/universites")
@RequiredArgsConstructor
public class UniversiteController {
    private final IUniversiteService service;

    @GetMapping           public List<Universite> all(){ return service.findAll(); }
    @GetMapping("/{id}")  public Universite one (@PathVariable Long id){ return service.findById(id).orElse(null); }
    @PostMapping          public Universite create(@RequestBody Universite u){ return service.create(u); }
    @PutMapping("/{id}")  public Universite update(@PathVariable Long id, @RequestBody Universite u){ return service.update(id,u); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
    @PutMapping("/update-uni")
    public UniversiteDTO updateUni(@RequestParam long foyerId, @RequestParam long universiteId){return service.affecterFoyerAUniversite(foyerId,universiteId);}

}
