package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class E1608TwoCircles extends Application {
    private final Label lbStatus = new Label("Two circles intersect?");
    private final Circle circle1 = new Circle(50, 60, 30);
    private final Circle circle2 = new Circle(180, 56, 40);
    {
        circle1.setFill(Color.TRANSPARENT);
        circle1.setStroke(Color.BLACK);
        circle2.setFill(Color.TRANSPARENT);
        circle2.setStroke(Color.BLACK);
        circle1.setOnMouseDragged(e -> {
            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());
        });
        circle2.setOnMouseDragged(e -> {
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());
        });
    }

    // TODO: Check circles for intersection

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPain = new BorderPane();
        mainPain.setTop(lbStatus);
        Pane circlesPane = new Pane();
        circlesPane.getChildren().addAll(circle1, circle2);
        mainPain.setCenter(circlesPane);

        Pane leftInfo = new CircleInfoPane(circle1,"Enter circle 1 info:");
        Pane rightInfo = new CircleInfoPane(circle2,"Enter circle 2 info:");
        GridPane infoPane = new GridPane();
        infoPane.add(leftInfo, 0, 0);
        infoPane.add(rightInfo, 1, 0);
        mainPain.setBottom(infoPane);

        primaryStage.setScene(new Scene(mainPain));
        primaryStage.setTitle("TwoCircles");
        primaryStage.show();
    }

    private class CircleInfoPane extends BorderPane {
        private final Circle circle;

        public CircleInfoPane(Circle circle, String title) {
            this.circle = circle;
            init(title);

        }

        private void init(String title) {
            setStyle("-fx-border-color: gray; -webkit-fx-border-wi: 1px");
            setTop(new Label(title));
            GridBuilder builder = new GridBuilder();
            DoubleTextField tfCenterX = new DoubleTextField(3);
            DoubleTextField tfCenterY = new DoubleTextField(3);
            IntegerTextField tfRadius = new IntegerTextField(10, 3);
            tfCenterX.setNumber(circle.getCenterX());
            tfCenterY.setNumber(circle.getCenterY());
            tfRadius.setNumber((int)circle.getRadius());
            circle.centerXProperty().addListener(ob -> tfCenterX.setNumber(circle.getCenterX()));
            circle.centerYProperty().addListener(ob -> tfCenterY.setNumber(circle.getCenterY()));
            tfCenterX.setOnAction(e -> circle.setCenterX(tfCenterX.getNumber()));
            tfCenterY.setOnAction(e -> circle.setCenterY(tfCenterY.getNumber()));
            tfRadius.setOnAction(e -> circle.setRadius(tfRadius.getNumber()));
            builder.appendRow("Center x:", tfCenterX);
            builder.appendRow("Center y:", tfCenterY);
            builder.appendRow("Radius:", tfRadius);
            setCenter(builder.getGrid());
        }
    }
}
