/* 18.9 */
package learn.ijpds.ch18recursion.exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import learn.ijpds.ch18recursion.SierpinskiTrianglePane;

public class E1819SierpinskiTriangle extends Application {
    private final Button btLess = new Button("-");
    private final Button btMore = new Button("+");
    private SierpinskiTrianglePane pane;

    @Override
    public void start(Stage primaryStage) {
        initTrianglePane();
        BorderPane borderPane = createMainPane();
        primaryStage.setTitle("SierpinskiTriangle");
        primaryStage.setScene(new Scene(borderPane, 200, 210));
        primaryStage.show();
        pane.paint();
    }

    private void initTrianglePane() {
        pane = new SierpinskiTrianglePane();
        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    private BorderPane createMainPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(createButtonsPane());
        borderPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                orderUp();
            } else if (e.getCode() == KeyCode.DOWN) {
                orderDown();
            }
        });
        return borderPane;
    }

    private HBox createButtonsPane() {
        btLess.setOnAction(e -> orderDown());
        btLess.setDisable(true);
        btMore.setOnAction(e -> orderUp());
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btLess, btMore);
        return hBox;
    }

    private void orderUp() {
        pane.orderUp();
        if (pane.getOrder() > 0) {
            btLess.setDisable(false);
        }
    }

    private void orderDown() {
        pane.orderDown();
        if (pane.getOrder() == 0) {
            btLess.setDisable(true);
        }
    }
}
