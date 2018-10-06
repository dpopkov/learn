/*
E.14.1
Display four images in a grid pane.
*/
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E1401Display extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        String[] names = {"1.png", "2.png", "3.png", "4.png"};
        final int width = 2;
        int row = 0, col = 0;
        for (String name : names) {
            pane.add(new ImageView(new Image(name)), row, col++);
            if (col == width) {
                row++;
                col = 0;
            }
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("DisplayFourImages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
