/*
14.15
Display a SLOW sign.
 */
package learn.ijpds.ch14fx.exercises;

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

public class E1415SlowSign extends Application {
    @Override
    public void start(Stage primaryStage) {
        SlowSign slowSign = new SlowSign(120);
        Scene scene = new Scene(slowSign);
        primaryStage.setTitle("SlowSign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class SlowSign extends StackPane {
        private double size;
        private Polygon octagon;
        private Text text;

        private SlowSign(double size) {
            this.size = size;
            octagon = new Polygon();
            octagon.setFill(Color.RED);
            text = new Text("STOP");
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, size / 3.5));
            this.getChildren().addAll(octagon, text);
            resizeComponents();
        }

        private void resizeComponents() {
            final double cos45 = Math.cos(Math.PI / 4);
            double d = size / (2 * cos45 + 1);
            double d1 = d * cos45;
            double d2 = d1 + d;
            double d3 = size;
            octagon.getPoints().addAll(d1, 0D, d2, 0D, d3, d1, d3, d2, d2, d3, d1, d3, 0D, d2, 0D, d1);
        }
    }
}
