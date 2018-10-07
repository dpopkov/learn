/* 15.1 */
package learn.ijpds.ch15events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEvent extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);

        Button btOK = new Button("OK");
        Button btCancel = new Button("Cancel");
        btOK.setOnAction(new OKHandlerClass());
        btCancel.setOnAction(new CancelHandlerClass());
        pane.getChildren().addAll(btOK, btCancel);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("HandleEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class OKHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Ok button clicked.");
        }
    }

    private class CancelHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Cancel button clicked.");
        }
    }

}
