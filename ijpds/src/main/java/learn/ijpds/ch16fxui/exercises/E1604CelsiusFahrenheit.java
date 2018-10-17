/* 16.4 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.function.DoubleFunction;

public class E1604CelsiusFahrenheit extends Application {
    private final TextField tfCelsius = new TextField();
    private final TextField tfFahrenheit = new TextField();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = initGridPane();
        tfCelsius.setOnAction(e -> convertFromTo(tfCelsius, tfFahrenheit, this::celsiusToFahrenheit));
        tfFahrenheit.setOnAction(e -> convertFromTo(tfFahrenheit, tfCelsius, this::fahrenheitToCelsius));
        primaryStage.setScene(new Scene(grid, 300, 100));
        primaryStage.setTitle("CelsiusFahrenheit");
        primaryStage.show();
    }

    private GridPane initGridPane() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        grid.add(new Label("Celsius"), 0, 0);
        grid.add(tfCelsius,1, 0);
        grid.add(new Label("Fahrenheit"), 0, 1);
        grid.add(tfFahrenheit, 1, 1);
        return grid;
    }

    private void convertFromTo(TextField source, TextField destination, DoubleFunction<Double> converter) {
        double fromValue = Double.parseDouble(source.getText());
        double toValue = converter.apply(fromValue);
        destination.setText(String.format(Locale.ENGLISH, "%.1f", toValue));
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
