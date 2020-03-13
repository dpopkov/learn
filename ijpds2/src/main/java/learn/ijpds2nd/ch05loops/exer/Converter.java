package learn.ijpds2nd.ch05loops.exer;

public class Converter {
    public double celsiusToFahrenheit(int celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    public double fahrenheitToCelsius(int fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}
