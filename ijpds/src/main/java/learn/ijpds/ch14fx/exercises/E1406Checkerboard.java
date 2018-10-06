/*
14.6
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class E1406Checkerboard extends Application {

    private static final int SIZE = 8;
    private static final int CELL = 30;

    @Override
    public void start(Stage primaryStage) {
//        Pane pane = createGridPane(SIZE, CELL);
        Pane pane = createPane(SIZE, CELL);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("E1406Checkerboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane createPane(int numCells, int cellSize) {
        Group group = new Group();
        for (int row = 0; row < numCells; row++) {
            for (int col = 0; col < numCells; col++) {
                int x = col * cellSize;
                int y = row * cellSize;
                Rectangle r = new Rectangle(x, y, cellSize, cellSize);
                r.setFill((row + col) % 2 == 0 ? Color.WHITE: Color.BLACK);
                group.getChildren().add(r);
            }
        }
        return new Pane(group);
    }

    @SuppressWarnings("unused")
    private Pane createGridPane(int numCells, int cellSize) {
        GridPane pane = new GridPane();
        for (int row = 0; row < numCells; row++) {
            for (int col = 0; col < numCells; col++) {
                Rectangle r = new Rectangle(cellSize, cellSize);
                r.setFill((row + col) % 2 == 0 ? Color.WHITE: Color.BLACK);
                pane.add(r, col, row);
            }
        }
        return pane;
    }
}
