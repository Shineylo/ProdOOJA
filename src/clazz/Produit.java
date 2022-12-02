package clazz;

public abstract class Produit {
    private final String nom;
    private int prix;
    private final String marque;

    //Constructeur
    public Produit(String nom, int prix, String marque) {
        this.nom = nom;
        this.prix = prix;
        this.marque = marque;
    }

    //<========================= Getter / Setter =========================>
    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }


}
