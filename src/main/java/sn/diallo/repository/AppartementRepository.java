package sn.diallo.repository;

import sn.diallo.domain.*;

public interface AppartementRepository {
    Appartement[] getAllByProprietaire(Proprietaire proprietaire);
    Appartement[] getAllByLocataire(Locataire locataire);
    Appartement[] getAll();
    Appartement findById(int id);

}
