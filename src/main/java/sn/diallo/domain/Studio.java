package sn.diallo.domain;

public class Studio extends Local {
  public Studio (){

  }

  public Studio(int id, Type type, String superficie, String adresse, Proprietaire proprietaire, long prix){
    this.id = id;
    this.type = type;
    this.superficie = superficie;
    this.adresse = adresse;
    this.proprietaire = proprietaire;
    this.prix = prix;
  }


}
