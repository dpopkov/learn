/*
14.20
Draw an arrow line.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class E1420Arrow extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new ArrowPane();
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("E1420Arrow");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class ArrowPane extends Pane {
        private void paint() {
            this.getChildren().clear();
            drawArrowLine(Math.random() * getWidth(), Math.random() * getHeight(),
                    Math.random() * getWidth(), Math.random() * getHeight(), this);
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

    private static void drawArrowLine(double startX, double startY,
                                     double endX, double endY, Pane pane) {
        Line mainLine = new Line(startX, startY, endX, endY);
        double dY = endY - startY;
        double dX = endX - startX;
        double angle = Math.toDegrees(Math.atan(dY / dX));
        if (dX < 0) {
            angle += 180.0;
        }
        final double arrowAngle = 30;
        final double arrowLength = 12;
        Line line1 = createLineFrom(endX, endY, arrowLength, angle + 180 - arrowAngle / 2);
        Line line2 = createLineFrom(endX, endY, arrowLength, angle + 180 + arrowAngle / 2);
        pane.getChildren().addAll(mainLine, line1, line2);
    }

    @SuppressWarnings("SameParameterValue")
    private static Line createLineFrom(double fromX, double fromY, double length, double angle) {
        double x2 = fromX + length * Math.cos(Math.toRadians(angle));
        double y2 = fromY + length * Math.sin(Math.toRadians(angle));
        return new Line(fromX, fromY, x2, y2);
    }
}
