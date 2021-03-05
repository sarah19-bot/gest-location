package sn.diallo.domain;

public class Chambre extends Local{

  public Chambre (){}

  public Chambre(int id, Type type, String superficie, String adresse,
    Proprietaire proprietaire, long prix){
    this.id = id;
    this.type = type;
    this.superficie = superficie;
    this.adresse = adresse;
    this.proprietaire = proprietaire;
    this.prix = prix;
  }

}
