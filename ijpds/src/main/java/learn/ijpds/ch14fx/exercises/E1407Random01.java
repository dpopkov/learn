/*
14.7
Display random 0 or 1.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E1407Random01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setHgap(3);
        pane.setVgap(3);
        pane.setPadding(new Insets(3));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField tf = new TextField();
                tf.setPrefColumnCount(1);
                tf.setText(Math.random() > 0.5 ? "1" : "0");
                pane.add(tf, j, i);
            }
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Random01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
