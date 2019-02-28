package learn.ijpds.ch33netw.areaserver;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * GUI application that starts {@link AreaServer}.
 */
public class ServerApp extends Application implements Consumer<String> {
    private TextArea textArea;
    private AreaServer server;

    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        Scene scene = new Scene(new ScrollPane(textArea), 450, 200);
        primaryStage.setTitle("AreaServer");
        primaryStage.setScene(scene);
        primaryStage.show();
        server = new AreaServer(this);
        server.start();
    }

    @Override
    public void accept(String s) {
        Platform.runLater(() -> textArea.appendText(s + '\n'));
    }

    @Override
    public void stop() throws Exception {
        if (server != null) {
            server.close();
        }
    }
}
