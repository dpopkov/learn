/*
16.22
Play, loop, and stop a sound clip. (p709)
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class E1622PlaySound extends Application {
    private static final String AUDIO_FILE = "explorer.wav";

    private AudioClip audioClip;

    @Override
    public void start(Stage primaryStage) {
        String url = Paths.get("src/main/resources/audio/" + AUDIO_FILE).toUri().toString();
        audioClip = new AudioClip(url);
        HBox buttonsPane = createButtonsPane();
        primaryStage.setScene(new Scene(buttonsPane));
        primaryStage.setTitle("PlaySound");
        primaryStage.show();
    }

    private HBox createButtonsPane() {
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(10));
        pane.setAlignment(Pos.CENTER);
        Button btPlay = new Button("Play");
        btPlay.setOnAction(e -> {
            audioClip.setCycleCount(1);
            audioClip.play();
        });
        Button btLoop = new Button("Loop");
        btLoop.setOnAction(e -> {
            audioClip.setCycleCount(AudioClip.INDEFINITE);
            audioClip.play();
        });
        Button btStop = new Button("Stop");
        btStop.setOnAction(e -> audioClip.stop());
        pane.getChildren().addAll(btPlay, btLoop, btStop);
        return pane;
    }
}
