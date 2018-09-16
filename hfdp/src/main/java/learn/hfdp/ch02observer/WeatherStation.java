package learn.hfdp.ch02observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditions currentDisplay = new CurrentConditions(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        weatherData.setMeasurements(new Measurements(80, 65, 30.4));
        weatherData.setMeasurements(new Measurements(82, 70, 29.2));
        weatherData.setMeasurements(new Measurements(78, 90, 29.2));
    }
}
