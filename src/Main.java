import produit.clazz.*;
import stock.Stock;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Scanner
    static Scanner scn = new Scanner(System.in);
    //Toutes les listes de stock possible
    static ArrayList<Stock<ProduitToxique>> listeStockToxique = new ArrayList<Stock<ProduitToxique>>();
    static ArrayList<Stock<ProduitNonToxique>> listeStockNonToxique = new ArrayList<Stock<ProduitNonToxique>>();
    static ArrayList<Stock<ProduitFraisToxique>> listeStockFraisToxique = new ArrayList<Stock<ProduitFraisToxique>>();
    static ArrayList<Stock<ProduitFraisNonToxique>> listeStockFraisNonToxique = new ArrayList<Stock<ProduitFraisNonToxique>>();
    public static void main(String[] args) {
        //Si 0 Stock = Done
            //Creer un stock (taille max + quel genre) = Done
        //Menu
            //Nouveau Stock
            //Afficher tous les stocks d'un type
                //Consulter un Stock (Emplacement libre et produit avec quantité)
                    //Consulter un Produit
                    //Modifier une Quantité + supprimer si 0
            //Nouveau produit
                //Dans un stock déjà creer
                //Dans un nouveau stock
            // Chercher un produit dans tout les stocks (Nom produit + type)

        if(listeStockToxique.size() == 0 &&
           listeStockNonToxique.size() == 0 &&
           listeStockFraisToxique.size() == 0 &&
           listeStockFraisNonToxique.size() == 0){
            System.out.println("Bonjour, il n'existe aucun stock actuellement.\n");
            creerUnStock();
        }else{
            System.out.println("Bonjour, que voulez-vous faire ?\n" +
                    "1.Creer un stock.\n" +
                    "2.Afficher les stocks existants.\n" +
                    "3.Creer un produit.\n" +
                    "4.Chercher un produit dans les stocks.\n" +
                    "5.Quitter le programme");
            switch (Integer.parseInt(scn.nextLine())) {
                case 1 -> creerUnStock();
                case 2 -> afficherStock();
                case 3 -> creerUnProduit();
                case 4 -> chercherProduit();
                case 5 -> System.exit(0);
            }
        }

    }

    private static void chercherProduit() {
    }

    private static void creerUnProduit() {
    }

    private static void creerUnStock() {
        System.out.println("Choisisez un type de stock à creer:\n" +
                "1.Stock de produit neutre.\n" +
                "2.Stock de produit toxic.\n" +
                "3.Stock de produit frais.\n" +
                "4.Stock de produit frais et toxic.");
        switch (Integer.parseInt(scn.nextLine())) {
            case 1 -> {
                System.out.println("Rentrez L'adresse et la taille max du nouveau stock");
                listeStockNonToxique.add(new Stock<ProduitNonToxique>(1, "A"));
            }
            case 2 -> {
                System.out.println("Rentrez L'adresse et la taille max du nouveau stock");
                listeStockToxique.add(new Stock<ProduitToxique>(1, "A"));
            }
            case 3 -> {
                System.out.println("Rentrez L'adresse et la taille max du nouveau stock");
                listeStockFraisNonToxique.add(new Stock<ProduitFraisNonToxique>(1, "A"));
            }
            case 4 -> {
                System.out.println("Rentrez L'adresse et la taille max du nouveau stock");
                listeStockFraisToxique.add(new Stock<ProduitFraisToxique>(1, "A"));
            }
        }
    }

    private static void afficherStock() {

    }

    public static class Outils {
        public String prixToString(int prix) {
            return String.format("€ %d.%02d", prix/100, prix%100);
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
}
