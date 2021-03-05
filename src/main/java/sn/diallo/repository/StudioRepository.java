package sn.diallo.repository;

import sn.diallo.domain.*;

public interface StudioRepository {
    Studio[] getAllByProprietaire(Proprietaire proprietaire);
    Studio[] getAllByLocataire(Locataire locataire);
    Studio findById(int id);
}
