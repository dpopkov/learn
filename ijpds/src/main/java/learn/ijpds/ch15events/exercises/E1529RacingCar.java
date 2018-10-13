/*
15.29
Simulates car racing
 */
package learn.ijpds.ch15events.exercises;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E1529RacingCar extends Application {

    private static final int FRAME_DURATION = 20;
    private static final int CAR_MOVEMENT_PER_FRAME = 2;

    private Timeline animation;
    private Button btPlay;

    @Override
    public void start(Stage primaryStage) {
        final int carLength = 50;
        Car car = new Car(0, 70, carLength);
        Pane carPane = new Pane(car);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(carPane);
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        btPlay = new Button("Play");
        btPlay.setOnAction(e -> controlButtonClick());
        hBox.getChildren().add(btPlay);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 250, 140);
        primaryStage.setTitle("RacingCar");
        primaryStage.setScene(scene);
        primaryStage.show();

        animation = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION), event -> {
            if (car.getBaseX() >= carPane.getWidth()) {
                car.setBaseX(-carLength);
            } else {
                car.setBaseX(car.getBaseX() + CAR_MOVEMENT_PER_FRAME);
            }
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        car.setBaseX(-carLength);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP: animation.setRate(animation.getRate() * 1.1); break;
                case DOWN: animation.setRate(animation.getRate() / 1.1); break;
            }
        });
    }

    private void controlButtonClick() {
        if (animation.getStatus() == Animation.Status.RUNNING) {
            animation.pause();
            btPlay.setText("Play");
        } else {
            animation.play();
            btPlay.setText("Pause");
        }
    }

    private class Car extends Group {
        private final double module;
        private final Polygon top;
        private final Rectangle middle;
        private final Circle wheel1;
        private final Circle wheel2;
        private double baseX;
        private final double baseY;

        public Car(double x, double y, double length) {
            module = length / 5;
            baseX = x;
            baseY = y;
            top = new Polygon(module, module, module, module, module, module, module, module);
            top.setFill(Color.DEEPSKYBLUE);
            middle = new Rectangle();
            middle.setFill(Color.CADETBLUE);
            middle.setWidth(module * 5);
            middle.setHeight(module);
            wheel1 = new Circle(module * 0.5);
            wheel2 = new Circle(module * 0.5);
            this.getChildren().addAll(top, middle, wheel1, wheel2);
            setComponentsLocations();
        }

        public double getBaseX() {
            return baseX;
        }

        public void setBaseX(double baseX) {
            this.baseX = baseX;
            setComponentsLocations();
        }

        private void setComponentsLocations() {
            setLocationOfTop();
            middle.setX(baseX);
            middle.setY(baseY - module * 2);
            wheel1.setCenterX(baseX + module * 1.5);
            wheel1.setCenterY(baseY - module * 0.5);
            wheel2.setCenterX(baseX + module * 3.5);
            wheel2.setCenterY(baseY - module * 0.5);
        }

        private void setLocationOfTop() {
            ObservableList<Double> points = top.getPoints();
            points.set(0, baseX + module);
            points.set(1, baseY - module * 2);
            points.set(2, baseX + module * 4);
            points.set(3, baseY - module * 2);
            points.set(4, baseX + module * 3);
            points.set(5, baseY - module * 3);
            points.set(6, baseX + module * 2);
            points.set(7, baseY - module * 3);
        }
    }
}
