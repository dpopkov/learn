/*
14.24
Inside a polygon.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class E1425Inside extends Application {
    @Override
    public void start(Stage primaryStage) {
        List<String> params = getParameters().getUnnamed();
        if (params.size() < 10) {
            System.out.println("Needs coordinates of 5 points.");
            System.exit(1);
        }
        Pane pane = new PolygonPane(params);
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Inside a Polygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class PolygonPane extends Pane {
    PolygonPane(List<String> coordinates) {
        Polygon p = new Polygon();
        for (int i = 0; i < 8; i++) {
            p.getPoints().add(Double.parseDouble(coordinates.get(i)));
        }
        p.setFill(Color.TRANSPARENT);
        p.setStroke(Color.BLACK);
        double circleX = Double.parseDouble(coordinates.get(coordinates.size() - 2));
        double circleY = Double.parseDouble(coordinates.get(coordinates.size() - 1));
        Circle c = new Circle(circleX, circleY, 2);
        String result = p.contains(circleX, circleY)
                ? "The point is inside the polygon"
                : "The point is outside the polygon";
        Text t = new Text(40, 150, result);
        getChildren().addAll(p, c, t);
    }
}