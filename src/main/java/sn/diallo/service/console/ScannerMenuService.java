package sn.diallo.service.console;

import sn.diallo.repository.AppartementRepository;
import sn.diallo.repository.LocataireRepository;
import sn.diallo.repository.ProprietaireRepository;
import sn.diallo.service.*;
import sn.diallo.domain.*;

import java.util.Scanner;

public class ScannerMenuService implements MenuService{
    private final DisplayService displayService;
    private final Scanner scanner;
    private final AppartementRepository appartementRepository;
    private final LocataireRepository locataireRepository;
    private final ProprietaireRepository proprietaireRepository;

    public ScannerMenuService(DisplayService displayService, AppartementRepository appartementRepository, LocataireRepository locataireRepository, ProprietaireRepository proprietaireRepository) {
        this.displayService = displayService;
        this.locataireRepository = locataireRepository;
        this.scanner = new Scanner(System.in);
        this.appartementRepository = appartementRepository;
        this.proprietaireRepository = proprietaireRepository;
    }


    private String lireChoix() {
        return scanner.next();
    }

    private void afficherMenu( String choix) {
        Appartement[] appartements = appartementRepository.getAll();
        Proprietaire[] proprietaires = proprietaireRepository.getAll();
        Locataire[] locataires = locataireRepository.getAll();
        if("a".equalsIgnoreCase(choix)){
            displayService.afficherListeLocals(appartements);
            int idAppart = scanner.nextInt();
            //get Appart by id
            Appartement appartement = appartementRepository.findById(idAppart);
            //get locataire & proprietaire by appartement
            Locataire locataire = locataireRepository.getByApart(appartement);
            Proprietaire proprietaire = proprietaireRepository.getByAppart(appartement);
            //afficher le locataire et le proprietaire de l'appart
            displayService.afficherLocatairePropForAppart(appartement, locataire, proprietaire);
        }
        else if ("p".equalsIgnoreCase(choix)){
            //afficher la liste de tous les proprietaires
            displayService.afficherListeProprietaires(proprietaires);
            //l'user selectionne un proprietaire
            int idProp = scanner.nextInt();
            Proprietaire prop = proprietaireRepository.findById(idProp);
            //get appartements by proprietaire
            Appartement[] appartements1 = appartementRepository.getAllByProprietaire(prop);
            //afficher les apparts du proprietaire
            displayService.afficherLocalProprietaire(prop, appartements1);
        }else if ("l".equalsIgnoreCase(choix)){
            //aficher la liste de tous les locataires
            displayService.afficherListeLocataires(locataires);
            //l'user selectionne un locataire
            int idLocataire = scanner.nextInt();
            Locataire locataire = locataireRepository.findById(idLocataire);
            //get appartement by locataire
            Appartement[] appartements1 = appartementRepository.getAllByLocataire(locataire);
            //afficher les apparts du locataire
            displayService.afficherLocalLocataire(locataire, appartements1);
        }else{
            //afficher le menu inconnu
            displayService.afficherOptionInconnue();
        }
    }

    public void afficherMenu() {
        String choix = lireChoix();
        afficherMenu(choix );
    }
}
