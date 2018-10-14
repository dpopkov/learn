/* 14.20 */
package learn.ijpds.ch14fx.clock;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DisplayClock extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        Label current = new Label(clock.getCurrentTime());

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(current);
        BorderPane.setAlignment(current, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
