/* 15.6 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1506AlternateTwoMessages extends Application {
    private Text text;

    @Override
    public void start(Stage primaryStage) {
        text = new Text(10, 50, "Welcome to Java");
        Pane pane = new Pane();
        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 150, 100);
        scene.setOnMouseClicked(e -> changeText());
        primaryStage.setTitle("AlternateMessages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changeText() {
        if (text.getText().equals("Welcome to Java")) {
            text.setText("Learning JavaFX");
        } else {
            text.setText("Welcome to Java");
        }
    }
}
