/*
14.2
Tic-tac-toe board.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E1402TicTac extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        Image x = new Image("x.png");
        Image o = new Image("o.png");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                double rnd = Math.random();
                if (rnd < 0.333) {
                    pane.add(new ImageView(x), r, c);
                } else if (rnd < 0.667) {
                    pane.add(new ImageView(o), r, c);
                }
            }
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("E1402TicTac");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
