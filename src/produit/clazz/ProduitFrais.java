package produit.clazz;

public abstract class ProduitFrais extends Produit {
    private int temperature;

    //Constructeur
    public ProduitFrais(String nom, int prix, String marque, int temperature) {
        super(nom, prix, marque);
        this.temperature = temperature;
    }

    //<========================= Getter / Setter =========================>

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int t) {
        this.temperature = temperature;
    }
}
