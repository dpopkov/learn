/* 15.08 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1508DisplayMousePosition extends Application {
    private Text txCoordinates;

    @Override
    public void start(Stage primaryStage) {
        Pane topPane = new Pane();
        EventHandler<MouseEvent> notHiding =
                e -> topPane.getChildren().add(new Text(e.getX(), e.getY(), getCoordinates(e)));
        EventHandler<MouseEvent> displayingOnPressed = e -> {
            txCoordinates = new Text(e.getX(), e.getY(), getCoordinates(e));
            topPane.getChildren().add(txCoordinates);
        };
        EventHandler<MouseEvent> removingOnReleased = event -> {
            txCoordinates.setText("");
            topPane.getChildren().remove(txCoordinates);
        };
        CheckBox cbErase = new CheckBox("Hide result");
        cbErase.setOnMouseClicked(e -> {
            if (cbErase.isSelected()) {
                topPane.setOnMouseClicked(null);
                topPane.setOnMousePressed(displayingOnPressed);
                topPane.setOnMouseReleased(removingOnReleased);
            } else {
                topPane.setOnMousePressed(null);
                topPane.setOnMouseReleased(null);
                topPane.setOnMouseClicked(notHiding);
            }
        });
        cbErase.setSelected(false);
        topPane.setOnMouseClicked(notHiding);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(topPane);
        borderPane.setBottom(cbErase);

        Scene scene = new Scene(borderPane, 320, 200);
        primaryStage.setTitle("DisplayMousePosition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getCoordinates(MouseEvent e) {
        return String.format("(%.1f, %.1f)", e.getX(), e.getY());
    }
}
