package learn.ijpds.ch33netw.multithead;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class MultiThreadServerApp extends Application implements Consumer<String> {
    private final TextArea textArea = new TextArea();
    private final MultiThreadServer server = new MultiThreadServer(this);

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ScrollPane(textArea), 450, 200);
        primaryStage.setTitle("MultiThreadServer");
        primaryStage.setScene(scene);
        primaryStage.show();
        new Thread(server).start();
    }

    @Override
    public void stop() throws Exception {
        server.close();
    }

    @Override
    public void accept(String s) {
        Platform.runLater(() -> textArea.appendText(s));
    }
}
