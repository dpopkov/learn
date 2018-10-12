/*
14.10
Display a cylinder.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class E1522Cylinder extends Application {

    @Override
    public void start(Stage primaryStage) {
        int centerX = 110;
        int radiusX = 90;
        int radiusY = 30;
        Pane pane = new StackPane();
        Cylinder cylinder = new Cylinder(pane, centerX, radiusX, radiusY, 100);
        pane.getChildren().add(cylinder);
        Scene scene = new Scene(pane, centerX * 2, 200);
        primaryStage.setTitle("Cylinder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class Cylinder extends Group implements InvalidationListener {
        private static final int MARGIN = 40;

        private final Pane pane;
        private double centerX;
        private final double topY;
        private double radiusX;
        private final double radiusY;
        private double height;
        private Ellipse ellipse;
        private Line left;
        private Line right;
        private Arc arc1;
        private Arc arc2;

        public Cylinder(Pane pane, double centerX, double radiusX, double radiusY, double height) {
            this.pane = pane;
            pane.widthProperty().addListener(this);
            pane.heightProperty().addListener(this);
            this.centerX = centerX;
            this.topY = radiusY;
            this.radiusX = radiusX;
            this.radiusY = radiusY;
            this.height = height;
            initComponents();
        }

        @Override
        public void invalidated(Observable observable) {
            resize(pane.getWidth() - MARGIN, pane.getHeight() - MARGIN);
        }

        @Override
        public void resize(double w, double h) {
            centerX = w / 2;
            radiusX = centerX;
            height = h - 2 * radiusY;
            resizeComponents();
        }

        private void resizeComponents() {
            ellipse.setCenterX(centerX);
            ellipse.setCenterY(topY);
            ellipse.setRadiusX(radiusX);
            ellipse.setRadiusY(radiusY);

            double bottomY = topY + height;
            double x = centerX - radiusX;
            left.setStartX(x);
            left.setStartY(topY);
            left.setEndX(x);
            left.setEndY(bottomY);

            x = centerX + radiusX;
            right.setStartX(x);
            right.setStartY(topY);
            right.setEndX(x);
            right.setEndY(bottomY);

            arc1.setCenterX(centerX);
            arc1.setCenterY(bottomY);
            arc1.setRadiusX(radiusX);
            arc1.setRadiusY(radiusY);

            arc2.setCenterX(centerX);
            arc2.setCenterY(bottomY);
            arc2.setRadiusX(radiusX);
            arc2.setRadiusY(radiusY);
        }

        private void initComponents() {
            ellipse = new Ellipse();
            ellipse.setFill(Color.TRANSPARENT);
            ellipse.setStroke(Color.BLACK);
            this.getChildren().add(ellipse);

            left = new Line();
            this.getChildren().add(left);
            right = new Line();
            this.getChildren().add(right);

            arc1 = new Arc();
            arc1.setStartAngle(180);
            arc1.setLength(180);
            arc1.setType(ArcType.OPEN);
            arc1.setFill(Color.TRANSPARENT);
            arc1.setStroke(Color.BLACK);
            this.getChildren().add(arc1);

            arc2 = new Arc();
            arc2.setStartAngle(0);
            arc2.setLength(180);
            arc2.setType(ArcType.OPEN);
            arc2.setFill(Color.TRANSPARENT);
            arc2.setStroke(Color.BLACK);
            arc2.getStrokeDashArray().addAll(6.0, 21.0);
            this.getChildren().add(arc2);

            resizeComponents();
        }
    }
}
