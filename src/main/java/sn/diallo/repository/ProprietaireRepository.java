package sn.diallo.repository;

import sn.diallo.domain.*;

public interface ProprietaireRepository {
    Proprietaire[] getAll();
    Proprietaire findById(int id);
    Proprietaire getByAppart(Appartement appartement);
}
