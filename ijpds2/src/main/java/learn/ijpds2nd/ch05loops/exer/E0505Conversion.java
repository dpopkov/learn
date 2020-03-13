package learn.ijpds2nd.ch05loops.exer;

public class E0505Conversion {
    public static void main(String[] args) {
        int c = 0;
        int dc = 2;
        int f = 20;
        int df = 5;
        Converter convert = new Converter();
        System.out.println("Celsius   Fahrenheit    |    Fahrenheit     Celsius");
        for (int row = 0; row < 51; row++) {
            System.out.printf("%7d   %10.3f    |    %10d     %7.3f%n",
                    c, convert.celsiusToFahrenheit(c), f, convert.fahrenheitToCelsius(f));
            c += dc;
            f += df;
        }
    }
}
