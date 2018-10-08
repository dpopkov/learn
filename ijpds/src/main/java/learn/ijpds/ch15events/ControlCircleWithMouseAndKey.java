/* 15.2  */
package learn.ijpds.ch15events;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircleWithMouseAndKey extends Application {
    private final CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        btEnlarge.setOnAction(e -> circlePane.enlarge());
        Button btShrink = new Button("Shrink");
        btShrink.setOnAction(e -> circlePane.shrink());
        hBox.getChildren().addAll(btEnlarge, btShrink);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircleWithMouseAndKey");
        primaryStage.setScene(scene);
        primaryStage.show();

        circlePane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                circlePane.enlarge();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                circlePane.shrink();
            }
        });
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                circlePane.enlarge();
            } else if (e.getCode() == KeyCode.DOWN) {
                circlePane.shrink();
            }
        });
    }

    private class CirclePane extends StackPane {
        private final Circle circle = new Circle(50);

        public CirclePane() {
            getChildren().add(circle);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.TRANSPARENT);
        }

        public void enlarge() {
            circle.setRadius(circle.getRadius() + 2);
        }

        public void shrink() {
            double current = circle.getRadius();
            circle.setRadius(current > 2 ? current - 2: current);
        }
    }
}
