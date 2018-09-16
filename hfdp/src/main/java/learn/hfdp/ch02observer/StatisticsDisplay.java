package learn.hfdp.ch02observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private double maxTemp = 0.0f;
    private double minTemp = 200;
    private double tempSum= 0.0f;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(Measurements measurements) {
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

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }
}
