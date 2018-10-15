/* 16.7 */
package learn.ijpds.ch16fxui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        DescriptionPane pane = new DescriptionPane();
        pane.setTitle("Canada");
        pane.setDescription("The Canadian national flag");
        pane.setImageView(new ImageView("image/ca.gif"));

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("TextAreaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
