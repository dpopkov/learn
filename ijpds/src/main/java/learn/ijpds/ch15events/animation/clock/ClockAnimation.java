/* 14.20 */
package learn.ijpds.ch15events.animation.clock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import learn.ijpds.ch14fx.clock.ClockPane;

public class ClockAnimation extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        Label current = new Label();
        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
            current.setText(String.format("%d:%02d:%02d", clock.getHour(), clock.getMinute(), clock.getSecond()));
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(current);
        BorderPane.setAlignment(current, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("ClockAnimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
