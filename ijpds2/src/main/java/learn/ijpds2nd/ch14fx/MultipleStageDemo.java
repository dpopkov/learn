package learn.ijpds2nd.ch14fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/* Listing 14.2 - augmented. */
public class MultipleStageDemo extends Application {
    private Stage lastStage;
    private int count;

    @Override
    public void start(Stage primaryStage) {
        Button btnOk = new Button("OK");
        btnOk.setOnAction(e -> addStage());
        Scene scene = new Scene(btnOk, 200, 250);
        primaryStage.setTitle(MultipleStageDemo.class.getSimpleName());
        primaryStage.setScene(scene);
        lastStage = primaryStage;
        count = 1;
        primaryStage.show();
    }

    private void addStage() {
        Stage stage = new Stage();
        stage.setTitle("stage #" + count);
        stage.setScene(new Scene(new Button("Stage " + count), 200, 200));
        count++;
        stage.setX(lastStage.getX() + 250);
        stage.setY(lastStage.getY());
        stage.setResizable(false);
        lastStage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
