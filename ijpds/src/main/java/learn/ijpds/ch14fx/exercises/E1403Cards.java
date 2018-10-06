/*
Display 3 random cards.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E1403Cards extends Application {
    private static final int NUM_CARDS = 54;
    private static final int NUM_VIEWS = 3;

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        String[] names = chooseCardNames(NUM_VIEWS);
        for (int i = 0; i < names.length; i++) {
            pane.add(new ImageView(new Image(names[i])), i, 0);
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("E1403Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @SuppressWarnings("SameParameterValue")
    private String[] chooseCardNames(int n) {
        String[] names = new String[n];
        List<Integer> numbers = new ArrayList<>(NUM_CARDS);
        for (int i = 1; i <= NUM_CARDS; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < names.length; i++) {
            names[i] = String.format("image/card/%d.png", numbers.get(i));
        }
        return names;
    }
}
