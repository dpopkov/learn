package introtdd.ch05di;

public class SaleReportRunner {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You must provide a command line argument specifying the file to analyse.");
            System.exit(-1);
        }
        CsvSalesRepository repo = new CsvSalesRepository(args[0]);
        repo.setError(System.err);
        SalesAnalysisService analyser = new SalesAnalysisService(repo);
        SaleReport report = new SaleReport(System.out, analyser);
        report.report();
    }
}
