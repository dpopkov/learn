/* 18.9 */
package learn.ijpds.ch18recursion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SierpinskiTriangle extends Application {

    @Override
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
        TextField tfOrder = new TextField();
        tfOrder.setOnAction(e -> {
            pane.setOrder(Integer.parseInt(tfOrder.getText()));
            System.out.println("display count: " + pane.getDisplayCount());
        });
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        primaryStage.setTitle("SierpinskiTriangle");
        primaryStage.setScene(new Scene(borderPane, 200, 210));
        primaryStage.show();

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }
}
