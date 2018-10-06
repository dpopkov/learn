/*
14.4
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1404ColorFont extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5));
        Font font = Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24);
        for (int i = 0; i < 5; i++) {
            Text t = new Text(10 + i * 60, 60, "JavaFX");
            t.setFont(font);
            t.setRotate(90);
            t.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            pane.getChildren().add(t);
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ColorFont");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
