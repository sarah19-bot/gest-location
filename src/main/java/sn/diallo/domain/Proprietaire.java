package sn.diallo.domain;

public class Proprietaire extends Personne {

    public Proprietaire(){}

    public Proprietaire(int id, String nom, String prenom, String adresse,
        String telephone, String email){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }
}
