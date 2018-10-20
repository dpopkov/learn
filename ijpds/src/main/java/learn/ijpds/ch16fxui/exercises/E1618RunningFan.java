package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class E1618RunningFan extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new ControlledRunningFan(220);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("RunningFan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
