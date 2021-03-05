package sn.diallo.repository;

import sn.diallo.domain.*;

public interface ChambreRepository {
    Chambre[] getAllByProprietaire(Proprietaire proprietaire);
    Chambre[] getAllByLocataire(Locataire locataire);
    Chambre findById(int id);
}
