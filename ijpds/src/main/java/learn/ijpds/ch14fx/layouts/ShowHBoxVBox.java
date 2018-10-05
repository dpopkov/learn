/* 14.13 */
package learn.ijpds.ch14fx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowHBoxVBox extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setTop(getHBox());
        pane.setLeft(getVBox());

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowHBoxVBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox getHBox() {
        HBox box = new HBox(15);
        box.setPadding(new Insets(15, 15, 15, 15));
        box.setStyle("-fx-background-color: gold");
        box.getChildren().add(new Button("Computer Science"));
        box.getChildren().add(new Button("Chemistry"));
        ImageView view = new ImageView(new Image("160px-JavaFX_Logo.png"));
        box.getChildren().add(view);
        return box;
    }

    private VBox getVBox(){
        VBox box = new VBox(15);
        box.setPadding(new Insets(15, 5, 5, 5));
        box.getChildren().add(new Label("Courses"));
        String[] courses = {"CSCI 1301", "CSCI 1302", "CSCI 2410", "CSCI 3720"};
        for (String c : courses) {
            Label label = new Label(c);
            VBox.setMargin(label, new Insets(0, 0, 0, 15));
            box.getChildren().add(label);
        }
        return box;
    }
}
