package learn.hfdp.ch02observer;

public class CurrentConditions implements Observer, DisplayElement {
    private Measurements measurements;
    private Subject weatherData;

    public CurrentConditions(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(Measurements measurements) {
        this.measurements = measurements;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + measurements.getTemperature()
                + "F degrees and " + measurements.getHumidity() + "% humidity");
    }
}
