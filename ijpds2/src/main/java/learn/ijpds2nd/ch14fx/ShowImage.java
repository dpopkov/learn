package learn.ijpds2nd.ch14fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/* Listing 14.9 */
public class ShowImage extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5));
        Image image = loadImage();
        pane.getChildren().add(new ImageView(image));

        ImageView imageView2 = new ImageView(image);
        imageView2.setFitWidth(100);
        imageView2.setFitHeight(100);
        pane.getChildren().add(imageView2);

        ImageView imageView3 = new ImageView(image);
        imageView3.setRotate(90);
        pane.getChildren().add(imageView3);

        Scene scene = new Scene(pane);
        primaryStage.setTitle(ShowImage.class.getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
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
//        InputStream is = ShowImage.class.getResourceAsStream("/images/donut.png");
//        System.out.println(is);
//        if (is != null) {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        launch(args);
    }
}
