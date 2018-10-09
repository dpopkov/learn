/*
15.10
Enter and display a string.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1510EnterDisplayString extends Application {
    @Override
    public void start(Stage primaryStage) {
        StringBuilder builder = new StringBuilder();
        Pane pane = new Pane();
        Text text = new Text(20, 40, "");
        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 240, 120);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                text.setText(builder.toString());
                builder.setLength(0);
            }
        });
        scene.setOnKeyTyped(e -> builder.append(e.getCharacter()));
        primaryStage.setTitle("EnterAndDisplayString");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
