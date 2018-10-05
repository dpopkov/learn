/* 14.9 */
package learn.ijpds.ch14fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));

        Image image = new Image("160px-JavaFX_Logo.png");
        pane.getChildren().add(new ImageView(image));

        ImageView view2 = new ImageView(image);
        view2.setFitHeight(100);
        view2.setFitWidth(100);
        pane.getChildren().add(view2);

        ImageView view3 = new ImageView(image);
        view3.setRotate(90);
        pane.getChildren().add(view3);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
