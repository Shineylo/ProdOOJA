package produit.clazz;
import produit.interfaze.Toxique;

public class ProduitFraisToxique extends ProduitFrais implements Toxique{
    private int toxicite;
    //Constructeur
    public ProduitFraisToxique(String nom, int prix, String marque, int temperature, int toxicite) {
        super(nom, prix, marque, temperature);
        this.toxicite = toxicite;
    }

    //<========================= Getter / Setter =========================>

    public int getToxicite() {
        return toxicite;
    }

    public void setToxicite(int toxicite) {
        this.toxicite = toxicite;
    }


    //<========================= Interface Toxique =========================>

    @Override
    public int getDoseLetale() {
        return this.getTemperature() * this.toxicite;
    }
}
