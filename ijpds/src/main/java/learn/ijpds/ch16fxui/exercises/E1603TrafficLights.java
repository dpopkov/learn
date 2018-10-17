/*
16.3
Simulates a traffic light.
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.EnumMap;

public class E1603TrafficLights extends Application {

    private TrafficLights trafficLights;

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(createTrafficLightPane());
        mainPane.setBottom(createRadioButtonsPane());
        primaryStage.setTitle("TrafficLight");
        primaryStage.setScene(new Scene(mainPane, 500, 200));
        primaryStage.show();
    }

    private Pane createTrafficLightPane() {
        StackPane pane = new StackPane();
        trafficLights = new TrafficLights(240);
        pane.getChildren().add(trafficLights);
        return pane;
    }

    private Pane createRadioButtonsPane() {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        ToggleGroup group = new ToggleGroup();
        hBox.getChildren().addAll(
                new ColorRadioButton("Red", group),
                new ColorRadioButton("Yellow", group),
                new ColorRadioButton("Green", group)
        );
        return hBox;
    }

    private class ColorRadioButton extends RadioButton {
        private final Light light;

        public ColorRadioButton(String text, ToggleGroup group) {
            super(text);
            setToggleGroup(group);
            light = Light.valueFromString(text);
            setOnAction(e -> E1603TrafficLights.this.trafficLights.turnOn(light));
        }
    }

    private enum Light {
        RED(Color.RED), YELLOW(Color.YELLOW), GREEN(Color.GREEN);

        private final Color color;

        Light(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public static Light valueFromString(String name) {
            return Light.valueOf(name.toUpperCase());
        }
    }

    private class TrafficLights extends Group {
        private static final int GAP = 10;

        private final EnumMap<Light, Circle> lights = new EnumMap<>(Light.class);

        private TrafficLights(@SuppressWarnings("SameParameterValue") int length) {
            int verticalHeight = length / 3;
            Rectangle rectangle = new Rectangle(length, verticalHeight);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(Color.BLACK);
            int radius = verticalHeight / 2 - GAP;
            int centerX = length / 2;
            int centerY = verticalHeight / 2;
            this.getChildren().addAll(
                    rectangle,
                    createLightCircle(centerX - (radius * 2 + GAP), centerY, radius, Light.RED),
                    createLightCircle(centerX, centerY, radius, Light.YELLOW),
                    createLightCircle(centerX + (radius * 2 + GAP), centerY, radius, Light.GREEN)
            );
        }

        private Circle createLightCircle(int centerX, int centerY, int radius, Light light) {
            Circle c = new Circle(centerX, centerY, radius);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            lights.put(light, c);
            return c;
        }

        public void turnOn(Light light) {
            turnOffAll();
            lights.get(light).setFill(light.getColor());
        }

        private void turnOffAll() {
            for (Circle c : lights.values()) {
                c.setFill(Color.TRANSPARENT);
            }
        }
    }
}
