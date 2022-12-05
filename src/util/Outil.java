package util;

import java.util.Scanner;

public class Outil {
    public static String prixToString(int prix) {
        return String.format(
                "€ %d.%02d",
                prix/100,
                prix%100
        );
    }

    // Demande un entier à l'utilisateur et vérifie qu'il est dans l'intervalle [1, nbChoix]
    public static int getChoixMenu(Scanner sc, int nbChoix) {
        int choix;
        do {
            try {
                choix = Integer.parseInt(sc.nextLine());
                if(choix > 0 && choix <= nbChoix)
                    return choix;
                else
                    System.out.println("Erreur: choix inconnu");
            } catch (NumberFormatException e) {
                System.out.println("Erreur: veuillez entrer un nombre entier");
            }
        } while(true);
    }
}
