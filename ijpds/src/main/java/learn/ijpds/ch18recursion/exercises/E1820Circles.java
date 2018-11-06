package learn.ijpds.ch18recursion.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class E1820Circles extends Application {

    @Override
    public void start(Stage primaryStage) {
        CirclesPane pane = new CirclesPane();
        primaryStage.setTitle("Display Circles");
        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();
    }

    private static class CirclesPane extends Pane {
        private static final int GAP = 10;

        public CirclesPane() {
            this.widthProperty().addListener(o -> paint());
            this.heightProperty().addListener(o -> paint());
        }

        public void paint() {
            this.getChildren().clear();
            double w = this.getWidth();
            double h = this.getHeight();
            double radius = (w < h ? w : h) / 2;
            addCirclesRecursive(w / 2, h / 2, radius);
        }

        private void addCirclesRecursive(double x, double y, double radius) {
            if (radius > 0) {
                Circle c = new Circle(x, y, radius);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(Color.DARKGREY);
                this.getChildren().add(c);
                addCirclesRecursive(x, y,radius - GAP);
            }
        }

    }
}
