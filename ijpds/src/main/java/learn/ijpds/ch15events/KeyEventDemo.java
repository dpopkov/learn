/* 15.8 */
package learn.ijpds.ch15events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {

    private static final int STEP = 10;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text(20, 20, "A");
        pane.getChildren().add(text);
        text.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN: text.setY(text.getY() + STEP); break;
                case UP: text.setY(text.getY() - STEP); break;
                case LEFT: text.setX(text.getX() - STEP); break;
                case RIGHT: text.setX(text.getX() + STEP); break;
                default:
                    if (e.getText().length() > 0) {
                        text.setText(e.getText());
                    }
                    break;
            }
        });

        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("MouseEventDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
        text.requestFocus();
    }
}
