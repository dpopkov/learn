/*
14.10
Display a cylinder.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class E1410Cylinder extends Application {

    @Override
    public void start(Stage primaryStage) {
        int centerX = 110;
        int radiusX = 90;
        int radiusY = 30;
        Cylinder cylinder = new Cylinder(centerX, 40, radiusX, radiusY, 100);
        Pane pane = new Pane();
        pane.getChildren().add(cylinder);
        Scene scene = new Scene(pane, centerX * 2, 200);
        primaryStage.setTitle("ResizeCylinder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class Cylinder extends Group {
        private double centerX;
        private double topY;
        private double radiusX;
        private double radiusY;
        private double height;
        private Ellipse ellipse;
        private Line left;
        private Line right;
        private Arc arc1;
        private Arc arc2;

        public Cylinder(double centerX, double topY, double radiusX, double radiusY, double height) {
            this.centerX = centerX;
            this.topY = topY;
            this.radiusX = radiusX;
            this.radiusY = radiusY;
            this.height = height;
            initComponents();
        }

        private void initComponents() {
            ellipse = new Ellipse(centerX, topY, radiusX, radiusY);
            ellipse.setFill(Color.TRANSPARENT);
            ellipse.setStroke(Color.BLACK);
            double bottomY = topY + height;
            double x;
            x = centerX - radiusX;
            left = new Line(x, topY, x, bottomY);
            x = centerX + radiusX;
            right = new Line(x, topY, x, bottomY);
            arc1 = new Arc(centerX, bottomY, radiusX, radiusY, 180, 180);
            arc1.setType(ArcType.OPEN);
            arc1.setFill(Color.TRANSPARENT);
            arc1.setStroke(Color.BLACK);
            arc2 = new Arc(centerX, bottomY, radiusX, radiusY, 0, 180);
            arc2.setType(ArcType.OPEN);
            arc2.setFill(Color.TRANSPARENT);
            arc2.setStroke(Color.BLACK);
            arc2.getStrokeDashArray().addAll(6.0, 21.0);
            this.getChildren().addAll(ellipse, left, right, arc1, arc2);
        }
    }
}
