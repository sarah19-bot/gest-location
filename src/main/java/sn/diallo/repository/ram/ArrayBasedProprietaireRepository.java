package sn.diallo.repository.ram;

import sn.diallo.domain.*;
import sn.diallo.repository.jdbc.*;
import sn.diallo.repository.*;

public class ArrayBasedProprietaireRepository implements ProprietaireRepository {

    public static final Proprietaire[] PROPRIETAIRES = {
            new Proprietaire(1, "Diallo", "Saratou", "Medina", "783684531", "s@gmail.com"),
            new Proprietaire(2, "Diallo", "Mariam", "Medina", "784958198", "m@gmail" ),
            new Proprietaire(3, "Dieng", "Mohamad", "Fass", "784958198", "d@gmail" ),
            new Proprietaire(4, "Fall", "Aissata", "Pikine", "784958198", "a@gmail" ),
    };

    public Proprietaire[] getAll() {
        return PROPRIETAIRES;
    }

    public Proprietaire findById(int id) {
        for (int i = 0; i < PROPRIETAIRES.length; i++) {
            if(id == PROPRIETAIRES[i].getId()){
                return PROPRIETAIRES[i];
            }
        }
        return null;
    }

    public Proprietaire getByAppart(Appartement appartement) {
        for (int i = 0; i < PROPRIETAIRES.length; i++) {
            if(appartement.getId() == PROPRIETAIRES[i].getId()){
                return PROPRIETAIRES[i];
            }
        }
        return null;
    }
}