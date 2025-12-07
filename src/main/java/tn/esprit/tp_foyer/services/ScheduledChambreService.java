package tn.esprit.tp_foyer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.repositories.BlocRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class ScheduledChambreService {


    private final BlocRepository blocRepository;

    // ➤ S’exécute chaque 1 minute
    @Transactional
    @Scheduled(fixedRate = 60000)
    public void listeChambresParBloc() {

        List<Bloc> blocs = blocRepository.findAll();

        for (Bloc bloc : blocs) {
            log.info("***************");
            log.info("Bloc » {} ayant une capacité {}", bloc.getNomBloc(), bloc.getCapaciteBloc());
            log.info("La Liste des chambres pour ce bloc:");

            if (bloc.getChambres().isEmpty()) {
                log.info("Pas de chambre disponible dans ce bloc");
            } else {
                for (Chambre ch : bloc.getChambres()) {
                    log.info("  → Chambre N°: {}  | type: {}", ch.getNumeroChambre(), ch.getTypeC());
                }
            }
        }
        log.info("***************");
    }
    @Transactional
    @Scheduled(fixedRate = 300000)
    public void pourcentageChambreParTypeChambre() {

        List<Chambre> chambres = blocRepository.findAll()
                .stream().flatMap(b -> b.getChambres().stream())
                .toList();

        int total = chambres.size();
        log.info("Nombre total des chambres: {}", total);

        if (total == 0) {
            log.info("Aucune chambre trouvée.");
            return;
        }

        double simple = chambres.stream().filter(c -> c.getTypeC().name().equals("SIMPLE")).count() * 100.0 / total;
        double doubleC = chambres.stream().filter(c -> c.getTypeC().name().equals("DOUBLE")).count() * 100.0 / total;
        double triple = chambres.stream().filter(c -> c.getTypeC().name().equals("TRIPLE")).count() * 100.0 / total;

        log.info("Le pourcentage des chambres pour le type SIMPLE est égal à {}", simple);
        log.info("Le pourcentage des chambres pour le type DOUBLE est égal à {}", doubleC);
        log.info("Le pourcentage des chambres pour le type TRIPLE est égal à {}", triple);





    }

    @Transactional
    @Scheduled(fixedRate = 300000)
    public void nbPlacesDisponibleParChambreAnneeEnCours() {

        List<Bloc> blocs = blocRepository.findAll();

        for (Bloc bloc : blocs) {
            for (Chambre chambre : bloc.getChambres()) {

                int capacite = switch (chambre.getTypeC()) {
                    case SIMPLE -> 1;
                    case DOUBLE -> 2;
                    case TRIPLE -> 3;
                };

                int nbOccupes = chambre.getReservations().size();

                int disponibles = capacite - nbOccupes;

                if (disponibles == 0) {
                    log.info("La chambre {} est complète", chambre.getNumeroChambre());
                } else {
                    log.info("Le nombre de places disponibles pour la chambre {} est {}",
                            chambre.getNumeroChambre(), disponibles);
                }
            }
        }
    }



}
