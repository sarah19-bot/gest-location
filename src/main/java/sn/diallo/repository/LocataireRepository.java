package sn.diallo.repository;

import sn.diallo.domain.*;

public interface LocataireRepository {
    Locataire[] getAll();
    Locataire findById(int id);
    Locataire getByApart(Appartement appartement);
}
