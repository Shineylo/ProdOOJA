package stock.exceptions;

public class ArticleInconnuException extends RuntimeException {
    public ArticleInconnuException() {
        super("Erreur: article inconnu du stock");
    }
}
