/*
15.28
Displays a running fan.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E1528RunningFan extends Application {
    @Override
    public void start(Stage primaryStage) {
        RunningFan fanPane = new RunningFan(200);

        Button btPlay = new Button("Play");
        btPlay.setOnAction(e -> fanPane.play());
        Button btPause = new Button("Pause");
        btPause.setOnAction(e -> fanPane.pause());
        Button btReverse = new Button("Reverse");
//        btReverse.setOnAction(e -> fanPane.reverse());

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPlay, btPause, btReverse);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(fanPane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("RunningFan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
