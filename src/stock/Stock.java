package stock;

import produit.clazz.Produit;
import stock.exceptions.ArticleInconnuException;
import stock.exceptions.PasAssezDeStockException;
import stock.exceptions.StockPleinException;
import util.Outil;

import java.util.HashMap;
import java.util.Map;

public class Stock<P extends Produit> {
    private final int taille;
    private final String adresse;
    private final Map<P, Integer> stock = new HashMap<>();
    private int qtUtilise = 0;

    public Stock(int taille, String adresse) {
        this.taille = taille;
        this.adresse = adresse;
    }

    public int getTaille() {
        return taille;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getQtUtilise() {
        return qtUtilise;
    }

    public int getQtDisponible() {
        return taille - qtUtilise;
    }

    private void ajoutQtUtilise(int qt) {
        if(qtUtilise + qt > taille)
            throw new StockPleinException();

        qtUtilise += qt;
    }

    private static void checkArgumentPlusGrandQueZero(int qt) {
        if(qt < 0)
            throw new IllegalArgumentException("L'argument devrait être positif");
    }

    private int getQtArticle(P p) {
        Integer qt = stock.get(p);
        if(qt == null)
            throw new ArticleInconnuException();
        return qt;
    }

    public void ajouter(P p, int qt) {
        checkArgumentPlusGrandQueZero(qt);
        ajoutQtUtilise(qt);

        if(stock.containsKey(p))
            stock.put(p, qt + stock.get(p));
        else
            stock.put(p, qt);
    }

    public void modifier(P p, int qt) {
        checkArgumentPlusGrandQueZero(qt);
        int previousQt = getQtArticle(p);
        ajoutQtUtilise(qt-previousQt);
        stock.put(p, qt);
    }

    public int retirerTout(P p) {
        int previousQt = getQtArticle(p);
        ajoutQtUtilise(-previousQt);
        stock.remove(p);
        return previousQt;
    }

    public void retirer(P p, int qt) {
        checkArgumentPlusGrandQueZero(qt);
        int previousQt = getQtArticle(p);
        if(qt > previousQt)
            throw new PasAssezDeStockException();
        ajoutQtUtilise(-qt);
        stock.put(p, previousQt-qt);
    }

    private static <P extends Produit> int entryPrix(Map.Entry<P, Integer> e) {
        return e.getKey().getPrix()*e.getValue();
    }

    public int getValeurTotale() {
        return stock.entrySet().stream()
                .mapToInt(Stock::entryPrix)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stock.entrySet().forEach(e -> stringBuilder
                        .append("Article: ")
                        .append(e.getKey())
                        .append(", Quantité: ")
                        .append(e.getValue())
                        .append(", Prix total: ")
                        .append(Outil.prixToString(Stock.entryPrix(e)))
                        .append("\n")
        );
        stringBuilder.append("Prix total de tous les articles: ")
                .append(Outil.prixToString(getValeurTotale()))
                .append("\n");
        return stringBuilder.toString();
    }
}
