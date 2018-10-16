/* 16.11 */
package learn.ijpds.ch16fxui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SliderDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(20, 20, "JavaFX Programming");

        Slider slHorizontal = new Slider();
        slHorizontal.setShowTickLabels(true);
        slHorizontal.setShowTickMarks(true);

        Slider slVertical = new Slider();
        slVertical.setOrientation(Orientation.VERTICAL);
        slVertical.setShowTickLabels(true);
        slVertical.setShowTickMarks(true);
        slVertical.setValue(100);

        Pane textPane = new Pane();
        textPane.getChildren().add(text);
        slHorizontal.valueProperty().addListener(ov ->
                text.setX(slHorizontal.getValue() * textPane.getWidth() / slHorizontal.getMax()));
        slVertical.valueProperty().addListener(ov ->
                text.setY((slVertical.getMax() - slVertical.getValue()) * textPane.getHeight() / slVertical.getMax()));

        BorderPane pane = new BorderPane();
        pane.setCenter(textPane);
        pane.setBottom(slHorizontal);
        pane.setRight(slVertical);

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("SliderDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
