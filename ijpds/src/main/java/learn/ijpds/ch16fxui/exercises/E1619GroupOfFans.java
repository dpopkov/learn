package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class E1619GroupOfFans extends Application {
    private static final int DIAMETER = 200;

    private final List<ControlledRunningFan> fans = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(createFansPane());
        borderPane.setBottom(createButtonPane());
        primaryStage.setTitle("GroupOfRunningFans");
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();
    }

    private HBox createButtonPane() {
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(10));
        Button btStartAll = new Button("Start All");
        btStartAll.setOnAction(e -> startAll());
        Button btStopAll = new Button("Stop All");
        btStopAll.setOnAction(e -> stopAll());
        pane.getChildren().addAll(btStartAll, btStopAll);
        return pane;
    }

    private HBox createFansPane() {
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(10));
        pane.getChildren().addAll(createFan(), createFan(), createFan());
        return pane;
    }

    private ControlledRunningFan createFan() {
        ControlledRunningFan fan = new ControlledRunningFan(DIAMETER);
        fans.add(fan);
        return fan;
    }

    private void startAll() {
        for (ControlledRunningFan fan : fans) {
            fan.play();
        }
    }

    private void stopAll() {
        for (ControlledRunningFan fan : fans) {
            fan.pause();
        }
    }
}
