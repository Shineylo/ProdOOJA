package stock.exceptions;

public class StockPleinException extends RuntimeException {
    public StockPleinException() {
        super("Erreur: impossible d'ajouter les articles, capacité de stockage dépassée");
    }
}
