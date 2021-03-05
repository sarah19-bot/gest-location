package sn.diallo.service.console;

import sn.diallo.repository.AppartementRepository;
import sn.diallo.service.*;
import sn.diallo.domain.*;

public class ConsoleDisplayService implements DisplayService{

    private final AppartementRepository appartementRepository;

    public ConsoleDisplayService(AppartementRepository appartementRepository) {
        this.appartementRepository = appartementRepository;
    }

    public void afficherBienvenu() {
        System.out.println("Bienvenu sur la plateforme de location!");
    }

    public void afficherMenuPrincipal() {
        System.out.println("> a pour lister les Appartements ");
        System.out.println("> p pour lister les Proprietaires ");
        System.out.println("> l pour lister les Locataires ");
    }

    public void afficherListeLocals(Appartement[] appartements) {
        System.out.println("Les locaux disponibles sont:");
        for (int i = 0; i < appartements.length; i++) {
            Appartement appartement = appartements[i];
            System.out.println(String.format("> %s", appartement.toString()));
        }
    }

    public void afficherListeLocataires(Locataire[] locataires) {
        System.out.println("Les locataires disponibles sont:");
        for (int i = 0; i < locataires.length; i++) {
            Locataire locataire = locataires[i];
            System.out.println(String.format("> %s", locataire.toString()));
        }
    }

    public void afficherListeProprietaires(Proprietaire[] proprietaires) {
        System.out.println("Les proprietaires disponibles sont:");
        for (int i = 0; i < proprietaires.length; i++) {
            Proprietaire proprietaire = proprietaires[i];
            System.out.println(String.format("> %s", proprietaire.toString()));
        }
    }

    public void afficherLocalProprietaire(Proprietaire proprietaire, Appartement[] appartements) {
        System.out.println(String.format("La liste des locaux de %s :", proprietaire.toString()));
        for (int i = 0; i < appartements.length; i++) {
            Appartement appartement = appartements[i];
            System.out.println(String.format("> %s", appartement.toString()));
        }
    }

    public void afficherDetailsLocal() {
        System.out.println("Les détails des locaux : ");
        /*Local[] locals = localRepository.getAll();
        for (int i = 0; i <detailPrestations.length; i++) {
            DetailPrestation detailPrestation = detailPrestations[i];
            System.out.println(
                    String.format(
                            "> %s %s : %s",
                            detailPrestation.getId(),
                            detailPrestation.getDetails(),
                            detailPrestation.getPrix()
                    )
            );
        }*/
    }

    public void afficherDetailslProprietaire(Appartement appartement){
        System.out.println(String.format("Proprietaire du local %s :", appartement.toString()));
    }

    public void afficherLocalLocataire(Locataire locataire, Appartement[] appartements){
        System.out.println(String.format("La liste des locaux loués par %s :", locataire.toString()));
        for (int i = 0; i < appartements.length; i++) {
            Appartement appartement = appartements[i];
            System.out.println(String.format("> %s", appartement.toString()));
        }
    }

    public void afficherPrixLocal(long prix){
        System.out.println(prix+" FCFA ");
    }

    @Override
    public void afficherLocatairePropForAppart(Appartement appartement, Locataire locataire, Proprietaire proprietaire) {
        System.out.println("-----------Local----------");
        System.out.println(String.format("\n > Type: %s", appartement.getType()));
        System.out.println(String.format("\n > Superficie: %s", appartement.getSuperficie()));
        System.out.println(String.format("\n > Adresse: %s", appartement.getAdresse()));
        System.out.println(String.format("\n > Prix: %s", appartement.getPrix()));
        System.out.println("-----------Locataire----------");
        System.out.println(String.format("\n > Nom %s", locataire.getNom()));
        System.out.println(String.format("\n > Prenom %s", locataire.getPrenom()));
        System.out.println(String.format("\n > Adresse %s", locataire.getAdresse()));
        System.out.println(String.format("\n > Tel %s", locataire.getTelephone()));
        System.out.println(String.format("\n > Mail %s", locataire.getEmail()));
        System.out.println("-----------Proprietaire----------");
        System.out.println(String.format("\n > Nom %s", proprietaire.getNom()));
        System.out.println(String.format("\n > Prenom %s", proprietaire.getPrenom()));
        System.out.println(String.format("\n > Adresse %s", proprietaire.getAdresse()));
        System.out.println(String.format("\n > Tel %s", proprietaire.getTelephone()));
        System.out.println(String.format("\n > Mail %s", proprietaire.getEmail()));
    }

    public void afficherOptionInconnue() {
        System.out.println("Choix inconnu");
    }

}
