package learn.ptddjp.stock;

public class StockManager {
    private ExternalIsbnDataService service;

    public void setService(ExternalIsbnDataService service) {
        this.service = service;
    }

    public String getLocatorCode(String isbn) {
        Book book = service.lookup(isbn);
        String last4isbn = isbn.substring(isbn.length() - 4);
        char firstAuthor = book.getAuthor().charAt(0);
        int numWords = book.getTitle().split(" ").length;
        return last4isbn + firstAuthor + numWords;
    }
}
