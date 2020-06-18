package learn.ijpds2nd.ch14fx;

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

import java.io.IOException;
import java.io.InputStream;

/* Listing 14.13 */
public class ShowHBoxVBox extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setTop(createHBox());
        pane.setLeft(createVBox());

        Scene scene = new Scene(pane);
        primaryStage.setTitle(ShowHBoxVBox.class.getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createHBox() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.getChildren().add(new Button("Computer Science"));
        hBox.getChildren().add(new Button("Chemistry"));
        ImageView imageView = new ImageView(loadImage());
        hBox.getChildren().add(imageView);
        return hBox;
    }

    @SuppressWarnings("SpellCheckingInspection")
    private VBox createVBox() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.getChildren().add(new Label("Courses"));
        String[] courses = {"CSCI 1301", "CSCI 1302", "CSCI 2410", "CSCI 3720"};
        for (String c : courses) {
            Label label = new Label(c);
            VBox.setMargin(label, new Insets(0, 0, 0, 15));
            vBox.getChildren().add(label);
        }
        return vBox;
    }

    private Image loadImage() {
        Image image = null;
        try (InputStream is = ShowImage.class.getResourceAsStream("/images/donut.png")) {
            image = new Image(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
