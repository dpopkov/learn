/*
15.1
Program that lets the user click the Refresh button to display four cards from a deck of 52 cards.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E1501PickCards extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImagePane imagePane = new ImagePane(4);
        BorderPane borderPane = new BorderPane();
        Button btRefresh = new Button("Refresh");
        btRefresh.setOnAction(e -> imagePane.pickCards());
        borderPane.setCenter(imagePane);
        borderPane.setBottom(btRefresh);
        BorderPane.setAlignment(btRefresh, Pos.CENTER);
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("PickCards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class ImagePane extends HBox {
        private static final int DECK_SIZE = 52;

        private final Image[] deck;
        private final ImageView[] views;

        @SuppressWarnings("SameParameterValue")
        private ImagePane(int numCards) {
            this.setSpacing(10);
            setPadding(new Insets(10));
            views = new ImageView[numCards];
            for (int i = 0; i < views.length; i++) {
                ImageView view = new ImageView();
                views[i] = view;
                this.getChildren().add(view);
            }
            deck = loadImages();
            pickCards();
        }

        public void pickCards() {
            List<Image> list = Arrays.asList(deck);
            Collections.shuffle(list);
            for (int i = 0; i < views.length; i++) {
                Image image = list.get(i);
                views[i].setImage(image);
            }
        }

        private Image[] loadImages() {
            Image[] images = new Image[DECK_SIZE];
            for (int i = 0; i < images.length; i++) {
                images[i] = new Image("image/card/" + (i + 1) + ".png");
            }
            return images;
        }
    }
}
