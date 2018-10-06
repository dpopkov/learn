/*
14.16
Display a 4 x 4 grid.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class E1416Grid extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new GridLinesPane(3, 4);
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class GridLinesPane extends Pane {
    private int numRows;
    private int numColumns;

    public GridLinesPane(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
    }

    private void paint() {
        getChildren().clear();
        double rowHeight = getHeight() / numRows;
        double colWidth = getWidth() / numColumns;
        int x = 0, y = 0;
        int endY = (int) getHeight();
        for (int i = 0; i < numColumns - 1; i++) {
            x += colWidth;
            Line line = new Line(x, y, x, endY);
            getChildren().add(line);
        }
        int endX = (int) getWidth();
        x = 0;
        y = 0;
        for (int i = 0; i < numRows - 1; i++) {
            y += rowHeight;
            Line line = new Line(x, y, endX, y);
            getChildren().add(line);
        }
    }

    @Override
    protected void setWidth(double value) {
        super.setWidth(value);
        paint();
    }

    @Override
    protected void setHeight(double value) {
        super.setHeight(value);
        paint();
    }
}