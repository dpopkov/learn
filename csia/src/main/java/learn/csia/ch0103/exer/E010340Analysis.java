package learn.csia.ch0103.exer;

public class E010340Analysis {

    public static final double INPUT_VALUE = 42.3;

    public static void main(String[] args) {
        final int seconds = 3;
        TestScaffold test1 = new TestScaffold(
                new CalculatorRunner(new MathCalculator(), INPUT_VALUE, 1000), "Math.exp()");
        test1.run(seconds);
        TestScaffold test2 = new TestScaffold(
                new CalculatorRunner(new TaylorSeriesCalculator(), INPUT_VALUE, 1000), "Taylor Series");
        test2.run(seconds);
    }

    private static class TestScaffold {
        private final CalculatorRunner calculatorRunner;
        private final String title;

        public TestScaffold(CalculatorRunner calculatorRunner, String title) {
            this.calculatorRunner = calculatorRunner;
            this.title = title;
        }

        public void run(int seconds) {
            Thread t = new Thread(calculatorRunner);
            System.out.printf("Starting '%s'%n", title);
            t.start();
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            calculatorRunner.stop();
            System.out.printf("Stopped '%s'. Count: %d%n", title, calculatorRunner.getCount());
        }
    }

    private static class TaylorSeriesCalculator implements Calculator {
        @Override
        public void calculate(double x) {
            double sum = 0.0;
            double term = 1.0;
            for (int i = 1; sum < sum + term; i++) {
                sum += term;
                term = term * x / i;
            }
        }
    }

    private static class MathCalculator implements Calculator{
        @SuppressWarnings("ResultOfMethodCallIgnored")
        @Override
        public void calculate(double input) {
            Math.exp(input);
        }
    }

    private static class CalculatorRunner implements Runnable {
        private volatile boolean running = true;
        private long count = 0;
        private final Calculator calculator;
        private final double input;
        private final int block;

        public CalculatorRunner(Calculator calculator, double input, int block) {
            this.calculator = calculator;
            this.input = input;
            this.block = block;
        }

        @Override
        public void run() {
            while (running) {
                for (int i = 0; i < this.block; i++) {
                    this.calculator.calculate(this.input);
                }
                count += this.block;
                if (!running) {
                    break;
                }
            }
        }

        void stop() {
            this.running = false;
        }

        public long getCount() {
            return count;
        }
    }

    private interface Calculator {
        void calculate(double input);
    }
}
