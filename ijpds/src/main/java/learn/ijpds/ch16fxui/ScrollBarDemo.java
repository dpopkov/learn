/* 16.10 */
package learn.ijpds.ch16fxui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(20, 20, "JavaFX Programming");
        ScrollBar sbHorizontal = new ScrollBar();
        ScrollBar sbVertical = new ScrollBar();
        sbVertical.setOrientation(Orientation.VERTICAL);

        Pane textPane = new Pane();
        textPane.getChildren().add(text);

        sbHorizontal.valueProperty().addListener(ov ->
                text.setX(sbHorizontal.getValue() * textPane.getWidth()
                        / sbHorizontal.getMax()));
        sbVertical.valueProperty().addListener(ov ->
                text.setY(sbVertical.getValue() * textPane.getHeight()
                        / sbVertical.getMax()));

        BorderPane pane = new BorderPane();
        pane.setCenter(textPane);
        pane.setBottom(sbHorizontal);
        pane.setRight(sbVertical);

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ScrollBarDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
