package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class E1609TwoRectangles extends Application {
    private final Label lbStatus = new Label("Two rectangles intersect?");
    private final Rectangle rect1 = new Rectangle(79, 20, 40, 50);
    private final Rectangle rect2 = new Rectangle(110, 33, 50, 20);

    public E1609TwoRectangles() {
        initCircles();
    }

    private void initCircles() {
        initRectangle(rect1);
        initRectangle(rect2);
    }

    private void initRectangle(Rectangle rect) {
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.BLACK);
        rect.setOnMouseDragged(e -> {
            rect.setX(e.getX());
            rect.setY(e.getY());
        });
        InvalidationListener moveListener = ob -> checkIntersection();
        rect.xProperty().addListener(moveListener);
        rect.yProperty().addListener(moveListener);
    }

    private void checkIntersection() {
        if (rect1.intersects(rect2.getBoundsInLocal())) {
            lbStatus.setText("Two rectangles intersect? Yes");
        } else {
            lbStatus.setText("Two rectangles intersect? No");
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPain = new BorderPane();
        mainPain.setTop(lbStatus);
        Pane circlesPane = new Pane();
        circlesPane.getChildren().addAll(rect1, rect2);
        mainPain.setCenter(circlesPane);

        Pane leftInfo = new RectangleInfoPane(rect1,"Enter rectangle 1 info:");
        Pane rightInfo = new RectangleInfoPane(rect2,"Enter rectangle 2 info:");
        GridPane infoPane = new GridPane();
        infoPane.add(leftInfo, 0, 0);
        infoPane.add(rightInfo, 1, 0);
        mainPain.setBottom(infoPane);

        primaryStage.setScene(new Scene(mainPain));
        primaryStage.setTitle("TwoRectangles");
        primaryStage.show();
    }

    private class RectangleInfoPane extends BorderPane {
        private final Rectangle rect;

        public RectangleInfoPane(Rectangle rect, String title) {
            this.rect = rect;
            init(title);
        }

        private void init(String title) {
            setStyle("-fx-border-color: gray; -webkit-fx-border-wi: 1px");
            setTop(new Label(title));
            GridBuilder builder = new GridBuilder();

            DoubleTextField tfX = new DoubleTextField(3);
            DoubleTextField tfY = new DoubleTextField(3);
            DoubleTextField tfWidth = new DoubleTextField( 3);
            DoubleTextField tfHeight = new DoubleTextField( 3);
            tfX.setNumber(rect.getX());
            tfY.setNumber(rect.getY());
            tfWidth.setNumber(rect.getWidth());
            tfHeight.setNumber(rect.getHeight());

            rect.xProperty().addListener(ob -> tfX.setNumber(rect.getX()));
            rect.yProperty().addListener(ob -> tfY.setNumber(rect.getY()));

            tfX.setOnAction(e -> rect.setX(tfX.getNumber()));
            tfY.setOnAction(e -> rect.setY(tfY.getNumber()));
            tfWidth.setOnAction(e -> rect.setWidth(tfWidth.getNumber()));
            tfHeight.setOnAction(e -> rect.setHeight(tfHeight.getNumber()));
            builder.appendRow("Center x:", tfX);
            builder.appendRow("Center y:", tfY);
            builder.appendRow("Width:", tfWidth);
            builder.appendRow("Height:", tfHeight);
            setCenter(builder.getGrid());
        }
    }
}
