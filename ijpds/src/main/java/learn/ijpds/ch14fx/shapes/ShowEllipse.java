/* 14.15 */
package learn.ijpds.ch14fx.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class ShowEllipse extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new EllipsePane(), 300, 200);
        primaryStage.setTitle("ShowEllipse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class EllipsePane extends Pane {
    private void paint() {
        getChildren().clear();
        double w2 = getWidth() / 2;
        double h2 = getHeight() / 2;
        for (int i = 0; i < 16; i++) {
            Ellipse e1 = new Ellipse(w2, h2, w2 - 50, h2 - 50);
            e1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            e1.setFill(Color.WHITE);
            e1.setRotate(i * 180.0 / 16);
            getChildren().add(e1);
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
