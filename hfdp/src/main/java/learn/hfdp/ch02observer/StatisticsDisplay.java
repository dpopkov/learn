package learn.hfdp.ch02observer;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private double maxTemp = 0.0f;
    private double minTemp = 200;
    private double tempSum= 0.0f;
    private int numReadings;

    public StatisticsDisplay(WeatherData weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            Measurements measurements = weatherData.getMeasurements();
            tempSum += measurements.getTemperature();
            numReadings++;

            if (measurements.getTemperature() > maxTemp) {
                maxTemp = measurements.getTemperature();
            }
            if (measurements.getTemperature() < minTemp) {
                minTemp = measurements.getTemperature();
            }
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }
}
