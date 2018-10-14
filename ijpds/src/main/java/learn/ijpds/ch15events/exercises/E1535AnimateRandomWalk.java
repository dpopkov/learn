/*
15.35
Animation: self-avoiding random walk.
 */
package learn.ijpds.ch15events.exercises;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E1535AnimateRandomWalk extends Application {
    private RandomWalkPane walkPane;
    private Timeline animation;

    @Override
    public void start(Stage primaryStage) {
        walkPane = new RandomWalkPane(20, 20, 20);
        initAnimation();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(walkPane);
        borderPane.setBottom(initButtonsPane());

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("AnimateRandomWalk");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initAnimation() {
        animation = new Timeline(new KeyFrame(Duration.millis(200), event -> {
            boolean moved = walkPane.step();
            if (!moved) {
//                walkPane.reset();
                animation.stop();
            }
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
    }

    private HBox initButtonsPane() {
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        Button btStart = new Button("Start");
        btStart.setOnAction(e -> {
            animation.play();
            btStart.setDisable(true);
        });
        Button btPause = new Button("Pause");
        btPause.setOnAction(e -> {
            animation.pause();
            btStart.setText("Resume");
            btStart.setDisable(false);
        });
        Button brReset = new Button("Reset");
        brReset.setOnAction(e -> {
            walkPane.reset();
            btStart.setText("Start");
            btStart.setDisable(false);
        });
        hBox.getChildren().addAll(btStart, btPause, brReset);
        return hBox;
    }
}
