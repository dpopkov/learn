/* 14.20 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E1532DisplayClock extends Application {
    @Override
    public void start(Stage primaryStage) {
        E1532ClockPane clock = new E1532ClockPane();
        Label current = new Label(clock.getCurrentTime());
        clock.addListener(o -> current.setText(clock.getCurrentTime()));

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        Button btStop = new Button("Stop");
        btStop.setOnAction(e -> clock.stop());
        Button btStart = new Button("Start");
        btStart.setOnAction(e -> clock.start());
        hBox.getChildren().addAll(btStop, btStart);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setTop(current);
        pane.setBottom(hBox);
        BorderPane.setAlignment(current, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
