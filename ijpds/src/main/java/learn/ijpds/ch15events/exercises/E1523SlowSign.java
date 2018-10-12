/*
15.23
Auto resize slow sign. Rewrite Programming Exercise 14.15 so that the slow
sign’s width and height are automatically resized when the window is resized.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1523SlowSign extends Application {
    @Override
    public void start(Stage primaryStage) {
        SlowSign slowSign = new SlowSign(100 + Math.random() * 20);
        Scene scene = new Scene(slowSign);
        primaryStage.setTitle("AutoResizeSlowSign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class SlowSign extends StackPane {
        private final double COS_45 = Math.cos(Math.PI / 4);

        private final Polygon octagon;
        private final Text text;

        private SlowSign(double size) {
            octagon = new Polygon();
            octagon.setFill(Color.RED);
            text = new Text("STOP");
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, size / 3.5));
            this.getChildren().addAll(octagon, text);
            resizeOctagon(size);

            widthProperty().addListener(observable -> setOctagonSize(getWidth(), getHeight()));
            heightProperty().addListener(observable -> setOctagonSize(getWidth(), getHeight()));
        }

        private void setOctagonSize(double w, double h) {
            resizeOctagon(Math.min(w, h));
        }

        private void resizeOctagon(double size) {
            Double side = size / (2 * COS_45 + 1);
            Double d1 = side * COS_45;
            Double d2 = d1 + side;
            Double d3 = size;
            octagon.getPoints().clear();
            octagon.getPoints().addAll(d1, 0D, d2, 0D, d3, d1, d3, d2, d2, d3, d1, d3, 0D, d2, 0D, d1);
        }
    }
}
