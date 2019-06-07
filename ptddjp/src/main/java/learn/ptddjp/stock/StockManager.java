package learn.ptddjp.stock;

public class StockManager {
    private ExternalIsbnDataService dbService;
    private ExternalIsbnDataService webService;

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

    public void setWebService(ExternalIsbnDataService webService) {
        this.webService = webService;
    }

    public void setDbService(ExternalIsbnDataService dbService) {
        this.dbService = dbService;
    }
}
