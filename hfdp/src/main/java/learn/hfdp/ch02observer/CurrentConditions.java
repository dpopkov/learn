package learn.hfdp.ch02observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditions implements Observer, DisplayElement {
    private Measurements measurements;

    public CurrentConditions(Observable weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + measurements.getTemperature()
                + "F degrees and " + measurements.getHumidity() + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.measurements = weatherData.getMeasurements();
            display();
        }
    }
}
