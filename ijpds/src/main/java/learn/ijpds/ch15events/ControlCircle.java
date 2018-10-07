/* 15.2  */
package learn.ijpds.ch15events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
    private final CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        btEnlarge.setOnAction(new EnlargeHandler());
        Button btShrink = new Button("Shrink");
        btShrink.setOnAction(new ShrinkHandler());
        hBox.getChildren().addAll(btEnlarge, btShrink);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            circlePane.enlarge();
        }
    }

    private class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            circlePane.shrink();
        }
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
