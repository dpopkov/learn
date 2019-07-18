package introtdd.ch06outsidein;

import java.io.PrintStream;

public class SalesReportRunner {
    private final PrintStream out;

    public static void main(String[] args) {
        String fileLocation = args[0];
        new SalesReportRunner(System.out).run(fileLocation);
    }

    public SalesReportRunner(PrintStream out) {
        this.out = out;
    }

    void run(String fileLocation) {
        out.println("Hello World");
    }
}
