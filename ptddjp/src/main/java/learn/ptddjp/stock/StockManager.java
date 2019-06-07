package learn.ptddjp.stock;

public class StockManager {
    private final ExternalIsbnDataService dbService;
    private final ExternalIsbnDataService webService;

    public StockManager(ExternalIsbnDataService dbService, ExternalIsbnDataService webService) {
        this.dbService = dbService;
        this.webService = webService;
    }

    public String getLocatorCode(String isbn) {
        Book book = dbService.lookup(isbn);
        if (book == null) {
            book = webService.lookup(isbn);
        }
        String last4isbn = isbn.substring(isbn.length() - 4);
        char firstAuthor = book.getAuthor().charAt(0);
        int numWords = book.getTitle().split(" ").length;
        return last4isbn + firstAuthor + numWords;
    }
}
