package Thibault.util;

public class Outils {
    public String prixToString(int prix) {
        return String.format("€ %d.%02d", prix/100, prix%100);
    }
}
