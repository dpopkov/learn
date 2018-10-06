/*
14.8
Display 54 cards.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E1408All54Cards extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        final int gap = 5;
        grid.setVgap(gap);
        grid.setHgap(gap);
        grid.setPadding(new Insets(gap));
        int row = 0, col = 0;
        for (int i = 1; i <= 54; i++) {
            grid.add(new ImageView(new Image(String.format("image/card/%d.png", i))), col++, row);
            if (col == 9) {
                row++;
                col = 0;
            }
        }
        Scene scene = new Scene(grid);
        primaryStage.setTitle("54 cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
