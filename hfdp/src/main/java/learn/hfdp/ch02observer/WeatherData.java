package learn.hfdp.ch02observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private Measurements measurements;
    private List<Observer> observers = new ArrayList<>();

    public void setMeasurements(Measurements measurements) {
        this.measurements = measurements;
        measurementsChanged();
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    private double getPressure() {
        return measurements.getPressure();
    }

    private double getHumidity() {
        return measurements.getHumidity();
    }

    private double getTemperature() {
        return measurements.getTemperature();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.measurements);
        }
    }
}
