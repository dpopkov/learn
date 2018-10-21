package learn.ijpds.ch16fxui.exercises;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import learn.ijpds.ch15events.exercises.RunningFan;

public class ControlledRunningFan extends BorderPane {
    private final RunningFan fanPane;

    public ControlledRunningFan(int diameter) {
        fanPane = new RunningFan(diameter);

        Button btPlay = new Button("Play");
        btPlay.setOnAction(e -> fanPane.play());
        Button btPause = new Button("Pause");
        btPause.setOnAction(e -> fanPane.pause());
        Button btReverse = new Button("Reverse");
//        btReverse.setOnAction(e -> fanPane.reverse());

        HBox controlsBox = new HBox(10);
        controlsBox.setPadding(new Insets(10));
        controlsBox.setAlignment(Pos.CENTER);
        controlsBox.getChildren().addAll(btPlay, btPause, btReverse);

        Slider slSpeed = new Slider();
        slSpeed.setMax(200);
        slSpeed.setValue(100);
        slSpeed.valueProperty().addListener(observable -> {
            double speedFactor = slSpeed.getValue() / slSpeed.getMax();
            fanPane.setSpeed(speedFactor);
        });

        this.setTop(controlsBox);
        this.setCenter(fanPane);
        this.setBottom(slSpeed);
    }

    public void play() {
        fanPane.play();
    }

    public void pause() {
        fanPane.pause();
    }
}
