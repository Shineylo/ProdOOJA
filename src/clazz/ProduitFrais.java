package clazz;

public abstract class ProduitFrais extends Produit {
    private int temperature;
    public ProduitFrais(String nom, int prix, String marque, int temperature) {
        super(nom, prix, marque);
        this.temperature = temperature;
    }
}
