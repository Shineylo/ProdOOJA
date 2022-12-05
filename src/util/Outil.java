package util;

public class Outil {
    public static String prixToString(int prix) {
        return String.format(
                "€ %d.%02d",
                prix/100,
                prix%100
        );
    }
}
