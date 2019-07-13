package introtdd.ch05di;

public class SaleReportRunner {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You must provide a command line argument specifying the file to analyse.");
            System.exit(-1);
        }
        SaleReport report = new SaleReport(System.out, args[0]);
        report.report();
    }
}
