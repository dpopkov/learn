/*
14.9
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class E1409Four extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        final int diameter = 120;
        grid.add(new TaichiPan(diameter), 0, 0);
        grid.add(new TaichiPan(diameter), 1, 0);
        grid.add(new TaichiPan(diameter), 0, 1);
        grid.add(new TaichiPan(diameter), 1, 1);
        Scene scene = new Scene(grid);
        primaryStage.setTitle("FourTaichis");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

class TaichiPan extends StackPane {
    TaichiPan(int diameter) {
        final int radius = diameter / 2;
        Circle circle = new Circle(radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        Group group = new Group();
        final int arcRadius = radius - 10;
        for (int i = 0, start = 26; i < 4; i++, start += 90) {
            Arc a1 = new Arc(centerX, centerY, arcRadius, arcRadius, start, 38);
            a1.setType(ArcType.ROUND);
            group.getChildren().add(a1);
        }
        getChildren().add(group);
    }
}
