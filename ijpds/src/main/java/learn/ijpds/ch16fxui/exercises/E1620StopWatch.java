/*
16.20
Simulates a count-up stopwatch.
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E1620StopWatch extends Application {
    private final CountDown countDown = new CountDown(1000);
    private final TimeLabelBox timeBox = new TimeLabelBox();

    @Override
    public void start(Stage primaryStage) {
        countDown.addListener(timeBox);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(timeBox);
        borderPane.setBottom(createButtonsBox());
        primaryStage.setScene(new Scene(borderPane, 300, 150));
        primaryStage.setTitle("Stopwatch");
        primaryStage.show();
    }

    private HBox createButtonsBox() {
        HBox buttonsPane = new HBox(10);
        buttonsPane.setPadding(new Insets(10));
        buttonsPane.setAlignment(Pos.CENTER);
        Button btStart = new Button("Start");
        btStart.setOnAction(e -> {
            if (btStart.getText().equals("Start")) {
                countDown.start();
                btStart.setText("Pause");
            } else {
                countDown.pause();
                btStart.setText("Start");
            }
        });
        Button btClear = new Button("Clear");
        btClear.setOnAction(e -> {
                countDown.stop();
                timeBox.reset();
                btStart.setText("Start");
            }
        );
        buttonsPane.getChildren().addAll(btStart, btClear);
        return buttonsPane;
    }
}
