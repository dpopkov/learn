package introtdd.ch06outsidein;

public class SalesAnalyser {
    private SalesRepository repo;

    public SalesAnalyser(SalesRepository repo) {
        this.repo = repo;
    }
}
