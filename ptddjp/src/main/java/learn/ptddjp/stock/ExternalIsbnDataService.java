package learn.ptddjp.stock;

public interface ExternalIsbnDataService {
    Book lookup(String isbn);
}
