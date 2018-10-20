package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E1619GroupOfFans extends Application {
    @Override
    public void start(Stage primaryStage) {
        // TODO: Add "Start All"/"Stop All" buttons
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        final int diameter = 200;
        hBox.getChildren().addAll(
                new ControlledRunningFan(diameter),
                new ControlledRunningFan(diameter),
                new ControlledRunningFan(diameter)
        );

        Scene scene = new Scene(hBox);
        primaryStage.setTitle("GroupOfRunningFans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
