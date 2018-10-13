/*
15.30
Automatically displays the slides repeatedly.
 */
package learn.ijpds.ch15events.exercises;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class E1530SlideShow extends Application {
    private static final int NUM_CARDS = 54;

    @Override
    public void start(Stage primaryStage) {
        final LoopedList<Image> images = initImages();
        final ImageView imageView = new ImageView(images.next());
        final Pane pane = new StackPane(imageView);
        final Scene scene = new Scene(pane);
        primaryStage.setTitle("SlideShow");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> imageView.setImage(images.next())));
        animation.setCycleCount(Timeline.INDEFINITE);
        scene.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.RUNNING) {
                animation.pause();
            } else {
                animation.play();
            }
        });
        animation.play();
    }

    private LoopedList<Image> initImages() {
        List<Image> list = new ArrayList<>();
        for (int i = 1; i <= NUM_CARDS; i++) {
            list.add(new Image("image/card/" + i + ".png"));
        }
        return new LoopedList<>(list);
    }

    private static class LoopedList<E> {
        private final List<E> list;
        private int index = -1;

        public LoopedList(List<E> list) {
            this.list = list;
        }

        public E next() {
            index++;
            if (index == list.size()) {
                index = 0;
            }
            return list.get(index);
        }
    }
}
