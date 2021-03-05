package sn.diallo.repository.ram;

import sn.diallo.domain.*;
import sn.diallo.repository.jdbc.*;
import sn.diallo.repository.LocataireRepository;

public class ArrayBasedLocataireRepository implements LocataireRepository {
    public static final Locataire[] LOCATAIRES = {
            new Locataire(1, "Diallo", "Saratou", "Medina", "783684531", "s@gmail.com"),
            new Locataire(2, "Diallo", "Mariam", "Medina", "784958198", "m@gmail" ),
            new Locataire(3, "Dieng", "Mohamad", "Fass", "784958198", "d@gmail" ),
            new Locataire(4, "Fall", "Aissata", "Pikine", "784958198", "a@gmail" ),
    };

    public Locataire[] getAll() {
        return LOCATAIRES;
    }

    public Locataire findById(int id) {
        for (int i = 0; i < LOCATAIRES.length; i++) {
            if(id == LOCATAIRES[i].getId()){
                return LOCATAIRES[i];
            }
        }
        return null;
    }

    public Locataire getByApart(Appartement appartement) {
        for (int i = 0; i < LOCATAIRES.length; i++) {
            if(appartement.getId() == LOCATAIRES[i].getId()){
                return LOCATAIRES[i];
            }
        }
        return null;
    }
}
