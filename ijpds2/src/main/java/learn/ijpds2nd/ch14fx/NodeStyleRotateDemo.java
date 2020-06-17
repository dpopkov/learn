package learn.ijpds2nd.ch14fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/* Listing 14.7 augmented */
public class NodeStyleRotateDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Button btOk = new Button("OK");
        btOk.setStyle("-fx-border-color: blue");
        pane.getChildren().add(btOk);
        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        pane.setOnMouseClicked(e -> pane.setRotate(pane.getRotate() + 5.0));
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle(NodeStyleRotateDemo.class.getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
