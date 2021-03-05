package sn.diallo.repository.ram;

import sn.diallo.domain.*;
import sn.diallo.repository.*;

import java.util.ArrayList;
import java.util.List;

public class ArrayBasedAppartementRepository implements AppartementRepository {

    static Proprietaire p = new Proprietaire(1, "Diallo", "Saratou", "Guediawaye", "783684531", "sarah@gmail.com");

    List<Appartement> appartements = new ArrayList<Appartement>();
    public static final Appartement[] APPARTEMENTS = {
            new Appartement(1, Type.T1Bis, "45x23", "Medina", p, 75000 ),
            new Appartement(2, Type.T1, "35x23", "Fann", p, 60000 ),
            new Appartement(3, Type.T1Bis, "85x35", "Dakar", p, 85000 ),
            new Appartement(4, Type.T1, "50x50", "Medina", p, 70000 ),
    };

    public Appartement[] getAllByProprietaire(Proprietaire proprietaire) {
        for (int i = 0; i < APPARTEMENTS.length; i++) {
            if(proprietaire.getId() == APPARTEMENTS[i].getProprietaire().getId()){
                appartements.add(APPARTEMENTS[i]);
            }
        }
        return appartements.toArray(new Appartement[0]);
    }

    public Appartement[] getAllByLocataire(Locataire locataire) {
        for (int i = 0; i < APPARTEMENTS.length; i++) {
            if(locataire.getId() == APPARTEMENTS[i].getId()){
                appartements.add(APPARTEMENTS[i]);
            }
        }
        return appartements.toArray(new Appartement[0]);
    }

    public Appartement[] getAll() {
        return APPARTEMENTS;
    }

    public Appartement findById(int id) {
        for (int i = 0; i < APPARTEMENTS.length; i++) {
            if(id == APPARTEMENTS[i].getId()){
                return APPARTEMENTS[i];
            }
        }
        return null;
    }
}
