package tn.esprit.tp_foyer.controllers;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.interfaces.IChambreService;
import java.util.List;

@RestController
@RequestMapping("/chambre")
@RequiredArgsConstructor
public class ChambreController {
    private final IChambreService chambreService;

    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @Operation(summary = "Get all chambres",
            description = "Returns a list of all chambres available in the system.")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @Operation(summary = "Add a new chambre",
            description = "Creates a new chambre with the provided details.")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }


    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
    @PutMapping("/update-bloc")
    public Chambre affecterBlocAChambre(@RequestParam long idBloc,@RequestParam long idChambre) {
        return chambreService.affecterBlocAChambre(idBloc,idChambre);
    }
}

