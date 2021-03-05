package sn.diallo.service;

import sn.diallo.domain.*;

public interface DisplayService {
    void afficherBienvenu();

    void afficherMenuPrincipal();

    void afficherListeLocals(Appartement[] appartements);

    void afficherListeLocataires(Locataire[] locataires);

    void afficherListeProprietaires(Proprietaire[] proprietaires);

    void afficherLocalProprietaire(Proprietaire proprietaire, Appartement[] appartements);

    void afficherDetailsLocal();

    void afficherDetailslProprietaire(Appartement appartement);

    void afficherLocalLocataire(Locataire locataire, Appartement[] appartements);

    void afficherPrixLocal(long prix);

    void afficherLocatairePropForAppart(Appartement appartement, Locataire locataire, Proprietaire proprietaire);

    void afficherOptionInconnue();

}
