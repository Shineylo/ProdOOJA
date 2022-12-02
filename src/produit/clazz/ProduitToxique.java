package produit.clazz;
import produit.interfaze.Toxique;

public class ProduitToxique extends Produit implements Toxique {
    private int toxicite;

    //Constructeur
    public ProduitToxique(String nom, int prix, String marque,int toxicite) {
        super(nom, prix, marque);
        this.toxicite = toxicite;
    }

    //<========================= Getter / Setter =========================>

    public int getToxicite() {
        return toxicite;
    }

    public void setToxicite(int toxicite) {
        this.toxicite = toxicite;
    }
}
