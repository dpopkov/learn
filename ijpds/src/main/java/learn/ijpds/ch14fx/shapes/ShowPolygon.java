/* 14.19 */
package learn.ijpds.ch14fx.shapes;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class ShowPolygon extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new PolygonPane(6), 400, 400);
        primaryStage.setTitle("ShowPolygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class PolygonPane extends Pane {
    private int numVertices;

    public PolygonPane(int numVertices) {
        this.numVertices = numVertices;
    }

    private void paint() {
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;
        for (int i = 0; i < numVertices; i++) {
            double angle = 2 * i * Math.PI / numVertices;
            list.add(centerX + radius * Math.cos(angle));
            list.add(centerY - radius * Math.sin(angle));
        }
        getChildren().clear();
        getChildren().add(polygon);
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