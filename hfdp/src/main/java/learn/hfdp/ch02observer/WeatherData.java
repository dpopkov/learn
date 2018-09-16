package learn.hfdp.ch02observer;

import java.util.Observable;

public class WeatherData extends Observable {
    private Measurements measurements;

    public void setMeasurements(Measurements measurements) {
        this.measurements = measurements;
        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public Measurements getMeasurements() {
        return this.measurements;
    }
}
