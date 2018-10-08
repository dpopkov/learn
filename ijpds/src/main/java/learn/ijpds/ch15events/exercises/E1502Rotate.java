/*
15.2
Rotate an Ellipse.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class E1502Rotate extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Ellipse ellipse = new Ellipse(100, 100, 80, 50);
        ellipse.setFill(Color.GREEN);
        pane.setCenter(ellipse);
        Button btRotate = new Button("Rotate");
        btRotate.setOnAction(e -> ellipse.setRotate(ellipse.getRotate() + 10));
        pane.setBottom(btRotate);
        BorderPane.setAlignment(btRotate, Pos.CENTER);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("RotateEllipse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
