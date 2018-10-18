package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HowToMoveAndUpdateTF extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50, 50, 40);
        circle.setOnMouseDragged(e -> {
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());
        });
        Pane pane = new Pane(circle);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        TextField tfCenterX = new TextField();
        circle.centerXProperty().addListener(observable ->
                tfCenterX.setText(Double.toString(circle.getCenterX())));
        borderPane.setBottom(tfCenterX);
        primaryStage.setScene(new Scene(borderPane, 300, 200));
        primaryStage.setTitle("HowToMoveAndUpdateTF");
        primaryStage.show();
    }
}
