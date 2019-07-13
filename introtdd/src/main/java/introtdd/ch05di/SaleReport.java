package introtdd.ch05di;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Map;

public class SaleReport {
    private final PrintStream output;
    private final SalesAnalysisService analyser;

    public SaleReport(PrintStream out, String fileLocation) {
        this.output = out;
        analyser = new SalesAnalysisService(fileLocation);
    }

    public void report() {
        output.printf("\nSales report for %s\n%n", LocalDate.now());
        printTable("Store Sales", analyser.tallyStoreSales());
        printTable("Product Sales", analyser.tallyProductSales());
    }

    private void printTable(String title, Map<String, Integer> values) {
        output.printf("------------%s------------%n", title);
        printRow(title, "Value");
        values.forEach((key, value) -> printRow(key, "" + value));
        output.println();
        output.println();
    }

    private void printRow(String first, String second) {
        output.printf("- %-15s - %6.6s -%n", first, second);
    }
}
