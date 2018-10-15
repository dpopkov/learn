/* 16.2 */
package learn.ijpds.ch16fxui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
    protected final Text text = new Text(50, 50, "JavaFX Programming");

    protected BorderPane getPane() {
        HBox buttonPane = new HBox(20);
        Button btLeft = new Button("Left", new ImageView("image/left.gif"));
        Button btRight = new Button("Right", new ImageView("image/right.gif"));
        buttonPane.getChildren().addAll(btLeft, btRight);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(buttonPane);

        Pane textPane = new Pane();
        textPane.getChildren().add(text);
        pane.setCenter(textPane);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        return pane;
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getPane(), 450, 250);
        primaryStage.setTitle("ButtonDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
