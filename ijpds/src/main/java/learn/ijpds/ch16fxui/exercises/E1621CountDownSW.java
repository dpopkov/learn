/*
16.21
Count-down stopwatch.
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class E1621CountDownSW extends Application {
    private final CountDown countDown = new CountDown(1000);

    @Override
    public void start(Stage primaryStage) {
        CountDownTextField tfSeconds = new CountDownTextField();
        countDown.addListener(tfSeconds);
        tfSeconds.setFont(Font.font(tfSeconds.getFont().getFamily(), FontWeight.BOLD, FontPosture.REGULAR, 36));
        tfSeconds.setAlignment(Pos.CENTER);
        tfSeconds.setOnAction(e -> {
            tfSeconds.reset();
            countDown.start(Integer.parseInt(tfSeconds.getText()));
        });
        Pane pane = new Pane(tfSeconds);
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("CountDown");
        primaryStage.show();
    }

    private class CountDownTextField extends TextField implements InvalidationListener {
        private boolean active = true;

        public void reset() {
            active = true;
        }

        public void tickDown() {
            try {
                int value = Integer.parseInt(this.getText());
                value--;
                if (value == 0) {
                    active = false;
                    this.setText("Time is up!");
                } else {
                    this.setText(Integer.toString(value));
                }
            } catch (NumberFormatException e) {
                active = false;
                this.setText("Enter number of seconds!");
            }

        }

        @Override
        public void invalidated(Observable observable) {
            if (active) {
                tickDown();
            }
        }
    }
}
