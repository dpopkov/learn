/* 16.7 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import learn.ijpds.ch14fx.clock.ClockPane;

public class E1607SetClockTime extends Application {
    private static final int COLUMN_COUNT = 3;

    private final ClockPane clockPane = new ClockPane();

    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(clockPane);

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5));
        IntegerTextField tfHour = new IntegerTextField(10, COLUMN_COUNT);
        IntegerTextField tfMinute = new IntegerTextField(10, COLUMN_COUNT);
        IntegerTextField tfSecond = new IntegerTextField(10, COLUMN_COUNT);
        tfHour.setOnAction(e -> clockPane.setHour(tfHour.getNumber()));
        tfMinute.setOnAction(e -> clockPane.setMinute(tfMinute.getNumber()));
        tfSecond.setOnAction(e -> clockPane.setSecond(tfSecond.getNumber()));
        hBox.getChildren().addAll(new Label("Hour"), tfHour,
                new Label("Minute"), tfMinute,
                new Label("Second"), tfSecond);
        BorderPane pane = new BorderPane();
        pane.setCenter(stackPane);
        pane.setBottom(hBox);
        primaryStage.setScene(new Scene(pane, 400, 300));
        primaryStage.setTitle("SetClockTime");
        primaryStage.show();
    }
}
