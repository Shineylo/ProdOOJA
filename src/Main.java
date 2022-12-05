import produit.clazz.*;
import stock.Stock;

import java.util.ArrayList;
import java.util.List;
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
                    //Déplacer/Ajouter un produit existant vers un autre stock
                    //Modifier une Quantité + supprimer si 0
            //Nouveau produit
                //Dans un stock déjà creer
                //Dans un nouveau stock
            // Chercher un produit dans tout les stocks (Nom produit + type)
        do {
            if (listeStockToxique.size() == 0 &&
                    listeStockNonToxique.size() == 0 &&
                    listeStockFraisToxique.size() == 0 &&
                    listeStockFraisNonToxique.size() == 0) {
                System.out.println("Bonjour, il n'existe aucun stock actuellement.\n");
                creerUnStock();
            } else {
                System.out.println("""
                        Bonjour, que voulez-vous faire ?
                        1.Creer un stock.
                        2.Afficher les stocks existants.
                        3.Creer un produit.
                        4.Chercher un produit dans les stocks.
                        5.Quitter le programme""");
                switch (Integer.parseInt(scn.nextLine())) {
                    case 1 -> creerUnStock();
                    case 2 -> afficherStock();
                    case 3 -> choisirTypeStock();
                    case 4 -> chercherProduit();
                    case 5 -> System.exit(0);
                }
            }
        }while (true);
    }

    private static void creerUnStock() {
        System.out.println("""
                Choisissez un type de stock à creer:
                1.Stock de produit neutre.
                2.Stock de produit toxic.
                3.Stock de produit frais.
                4.Stock de produit frais et toxic.""");
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
        System.out.println("""
                Choisissez un type de stock à afficher:
                1.Stock de produit neutre.
                2.Stock de produit toxic.
                3.Stock de produit frais.
                4.Stock de produit frais et toxic.""");
        switch (Integer.parseInt(scn.nextLine())) {
            case 1 -> {
                listeStockNonToxique.forEach(System.out::println);
            }
            case 2 -> {
                listeStockToxique.forEach(System.out::println);
            }
            case 3 -> {
                listeStockFraisNonToxique.forEach(System.out::println);
            }
            case 4 -> {
                listeStockFraisToxique.forEach(System.out::println);
            }
        }
    }

    private static void choisirTypeStock() {
        System.out.println("""
                        Veuillez entrer le type du produit
                        1.Stock de produit neutre.
                        2.Stock de produit toxic.
                        3.Stock de produit frais.
                        4.Stock de produit frais et toxic.""");
        int choix = Integer.parseInt(scn.nextLine());
        ArrayList<Stock<Produit>> liste;
        System.out.println("Veuillez entrer le nom du produit");
        String nom = scn.nextLine();
        System.out.println("Veuillez entrer le prix du produit");
        int prix = Integer.parseInt(scn.nextLine());
        System.out.println("Veuillez entrer la marque du produit");
        String marque = scn.nextLine();
        int toxicite = 0;
        int temperature = 0;
        if(choix==2||choix==4) {
            System.out.println("Veuillez entrer la toxicité du produit");
            toxicite = Integer.parseInt(scn.nextLine());
        }
        if(choix==3||choix==4) {
            System.out.println("Veuillez entrer la température de conservation du produit");
            temperature = Integer.parseInt(scn.nextLine());
        }
        System.out.println("Veuillez entrer la quantité désirée");
        int qt = Integer.parseInt(scn.nextLine());
        switch (choix) {
            case 1 -> {
                ProduitNonToxique p = new ProduitNonToxique(nom, prix,marque);
                ajouterProduitStock(listeStockNonToxique, qt);
            }
            case 2 -> {
                ProduitToxique p = new ProduitToxique(nom, prix, marque,toxicite);
            }
            case 3 -> {
                ProduitFraisNonToxique p = new ProduitFraisNonToxique(nom, prix, marque,temperature);
            }
            case 4 -> {
                ProduitFraisToxique p = new ProduitFraisToxique(nom, prix, marque, temperature, toxicite);
            }
        }
    }

    private static <P extends Produit> void ajouterProduitStock(ArrayList<Stock<P>> listeStock, int qt) {
        List<Stock<P>> listeStockLibre = listeStock.stream()
                .filter(s -> s.getQtDisponible() >= qt)
                .toList();

        System.out.println("Veuillez choisir le stock auquel ajouter le produit");
        int i;
        for(i = 0; i < listeStockLibre.size(); i++) {
            System.out.println((i+1) + ": Stock ");
        }
    }

    private static void chercherProduit() {

    }
}
