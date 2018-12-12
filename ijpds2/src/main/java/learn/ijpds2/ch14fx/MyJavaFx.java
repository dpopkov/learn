package learn.ijpds2.ch14fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyJavaFx extends Application {
    @Override
    public void start(Stage stage) {
        Button btOk = new Button("OK");
        Scene scene = new Scene(btOk, 200, 250);
        stage.setTitle("MyJavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
