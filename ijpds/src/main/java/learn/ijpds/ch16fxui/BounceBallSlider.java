/* 16.12 */
package learn.ijpds.ch16fxui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import learn.ijpds.ch15events.bouncingball.BallPane;

public class BounceBallSlider extends Application {
    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane();
        Slider slSpeed = new Slider();
        slSpeed.setMax(20);
        ballPane.rateProperty().bind(slSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(slSpeed);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("BounceBallSlider");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
