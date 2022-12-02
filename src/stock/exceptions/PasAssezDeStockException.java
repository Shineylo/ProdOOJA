package stock.exceptions;

public class PasAssezDeStockException extends RuntimeException {
    public PasAssezDeStockException() {
        super("Erreur: pas assez de stock pour retirer les articles");
    }
}
