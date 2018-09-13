package learn.core1.ch07.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.logging.Logger;

public class UsingLoggingProxy {
    public static void main(String[] args) {
        Random generator = new Random() {
            @Override
            public double nextDouble() {
                double result = super.nextDouble();
                Logger.getGlobal().info("nextDouble: " + result);
                Logger.getGlobal().info(getStackTrace());
                return result;
            }

            private String getStackTrace() {
                StringWriter out = new StringWriter();
                new Throwable().printStackTrace(new PrintWriter(out));
                return out.toString();
            }
        };
        useRandom(generator);
    }

    private static void useRandom(Random generator) {
        generator.nextDouble();
    }
}
