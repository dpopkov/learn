/*
16.17
Uses scroll bars to select the color for a text.
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1617ScrollBars extends Application {
    private Text text;

    @Override
    public void start(Stage primaryStage) {
        text = new Text("Show Colors");
        Font font = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 50);
        text.setFont(font);
        StackPane textPane = new StackPane(text);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textPane);
        borderPane.setBottom(initBarsPane());
        primaryStage.setScene(new Scene(borderPane, 400, 300));
        primaryStage.setTitle("ScrollBars");
        primaryStage.show();
    }

    private GridPane initBarsPane() {
        DoubleScrollBar sbRed = new DoubleScrollBar();
        DoubleScrollBar sbGreen = new DoubleScrollBar();
        DoubleScrollBar sbBlue = new DoubleScrollBar();
        DoubleScrollBar sbOpacity = new DoubleScrollBar();
        sbOpacity.setValue(sbOpacity.getMax());
        InvalidationListener listener = ov -> changeTextColor(
                sbRed.getDouble(), sbGreen.getDouble(),
                sbBlue.getDouble(), sbOpacity.getDouble()
        );
        sbRed.valueProperty().addListener(listener);
        sbGreen.valueProperty().addListener(listener);
        sbBlue.valueProperty().addListener(listener);
        sbOpacity.valueProperty().addListener(listener);
        GridBuilder builder = new GridBuilder();
        builder.appendRow("Red", sbRed);
        builder.appendRow("Green", sbGreen);
        builder.appendRow("Blue", sbBlue);
        builder.appendRow("Opacity", sbOpacity);
        return builder.getGrid();
    }

    private void changeTextColor(double r, double g, double b, double op) {
        text.setFill(Color.color(r, g, b, op));
    }

    private class DoubleScrollBar extends ScrollBar {
        public DoubleScrollBar() {
            this.setPrefWidth(300);
        }

        public double getDouble() {
            return this.getValue() / this.getMax();
        }
    }
}
