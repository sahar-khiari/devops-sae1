package tn.esprit.tp_foyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.interfaces.IBlocService;

@RestController
@RequestMapping("/bloc")
@RequiredArgsConstructor
public class BlocController {

    private final IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/get-bloc-by-chambre/5
    @Operation(summary = "Get bloc by chambre id",
            description = "Returns the bloc associated with the given chambre id.")
    @GetMapping("/get-bloc-by-chambre/{idChambre}")
    public Bloc getBlocByChambre(@PathVariable("idChambre") Long idChambre) {
        Bloc bloc = blocService.getBlocByChambreId(idChambre);
        return bloc;
    }
}
