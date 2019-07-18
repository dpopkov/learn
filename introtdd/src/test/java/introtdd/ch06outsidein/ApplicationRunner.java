package introtdd.ch06outsidein;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/* This class is part of a test framework. */
public class ApplicationRunner {
    public String run(String inputFile) {
        ByteArrayOutputStream dummyOutput = new ByteArrayOutputStream();
        SalesReportRunner app = new SalesReportRunner(new PrintStream(dummyOutput));
        app.run(inputFile);
        return dummyOutput.toString(StandardCharsets.UTF_8);
    }
}
