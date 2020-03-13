package learn.ijpds2nd.ch05loops.exer;

public class E0503ToFahrenheit {
    public static void main(String[] args) {
        Converter converter = new Converter();
        System.out.println("Celsius Fahrenheit");
        for (int c = 0; c <= 100; c++) {
            double f = converter.celsiusToFahrenheit(c);
            System.out.printf("%7d %10.1f%n", c, f);
        }
    }
}
