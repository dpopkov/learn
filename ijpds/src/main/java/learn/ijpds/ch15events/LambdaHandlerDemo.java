/* 15.4 */
package learn.ijpds.ch15events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LambdaHandlerDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        final Text text = new Text(40, 40, "Programming is fun");
        Pane pane = new Pane(text);

        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        HBox hBox = new HBox(btUp, btDown, btLeft, btRight);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        btUp.setOnAction((ActionEvent e) -> text.setY(text.getY() > 10 ? text.getY() - 5 : 10));
        btDown.setOnAction((e) -> text.setY(text.getY() < pane.getHeight() ? text.getY() + 5 : pane.getHeight()));
        btLeft.setOnAction(e -> text.setX(text.getX() > 0 ? text.getX() - 5 : 0));
        btRight.setOnAction(e -> text.setX(text.getX() < pane.getWidth() - 100 ? text.getX() + 5 : pane.getWidth() - 100));

        Scene scene = new Scene(borderPane, 400, 250);
        primaryStage.setTitle("LambdaHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
