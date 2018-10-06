/*
14.23
Two rectangles: are overlapping, of one is contained in the other, or they don't overlap.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class E1423TwoRect extends Application {
    @Override
    public void start(Stage primaryStage) {
        List<String> params = getParameters().getUnnamed();
        if (params.size() < 8) {
            System.out.println("Needs 8 parameters!");
            System.exit(1);
        }
        int x1 = Integer.parseInt(params.get(0));
        int y1 = Integer.parseInt(params.get(1));
        int w1 = Integer.parseInt(params.get(2));
        int h1 = Integer.parseInt(params.get(3));
        int x2 = Integer.parseInt(params.get(4));
        int y2 = Integer.parseInt(params.get(5));
        int w2 = Integer.parseInt(params.get(6));
        int h2 = Integer.parseInt(params.get(7));
        RectanglesPane pane = new RectanglesPane(x1, y1, w1, h1, x2, y2, w2, h2);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("TwoRectangles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class RectanglesPane extends Pane {

    public RectanglesPane(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
        Rectangle r1 = createRectangle(x1, y1, w1, h1);
        Rectangle r2 = createRectangle(x2, y2, w2, h2);
        Bounds b1 = r1.getBoundsInLocal();
        Bounds b2 = r2.getBoundsInLocal();
        String result;
        if (b1.contains(b2) || b2.contains(b1)) {
            result = "One rectangle is contained in another";
        } else if (b1.intersects(b2)) {
            result = "The rectangles overlap";
        } else {
            result = "The rectangles do not overlap";
        }
        int bottom = Math.max(y1 + h1, y2 + h2);
        Text text = new Text(20, bottom + 20, result);
        getChildren().addAll(r1, r2, text);
    }

    private Rectangle createRectangle(int x, int y, int width, int height) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        return rectangle;
    }
}
