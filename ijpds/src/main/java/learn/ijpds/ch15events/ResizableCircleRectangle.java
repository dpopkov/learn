/* 15.11 */
package learn.ijpds.ch15events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ResizableCircleRectangle extends Application {
    private static final int DIAMETER = 120;

    private Circle circle = new Circle(DIAMETER / 2.0);
    private Rectangle rectangle = new Rectangle(DIAMETER, DIAMETER);
    private StackPane pane = new StackPane();

    @Override
    public void start(Stage primaryStage) {
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        circle.setFill(Color.GRAY);
        pane.getChildren().addAll(rectangle, circle);
        Scene scene = new Scene(pane, DIAMETER + 20, DIAMETER + 20);
        primaryStage.setTitle("ResizableCircleRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.widthProperty().addListener(o -> resize());
        pane.heightProperty().addListener(o -> resize());
    }

    private void resize() {
        double length = Math.min(pane.getWidth(), pane.getHeight());
        circle.setRadius(length / 2 - 15);
        rectangle.setWidth(length - 30);
        rectangle.setHeight(length - 30);
    }
}
