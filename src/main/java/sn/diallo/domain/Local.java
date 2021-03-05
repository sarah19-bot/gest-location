package sn.diallo.domain;

abstract class Local {
    protected int id;
    protected Type type;
    protected String superficie;
    protected String adresse;
    protected Proprietaire proprietaire;
    protected long prix;

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getSuperficie() {
        return superficie;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public long getPrix() {
        return prix;
    }

    public String toString(){
        String str = this.getClass().getName()+"\n Adresse: "+this.adresse+
        "\n Type: "+this.type+"\n Superficie: "+this.superficie+"\n Proprietaire: "+this.proprietaire+"\n Prix: "+this.prix;
        return str;
    }
}
