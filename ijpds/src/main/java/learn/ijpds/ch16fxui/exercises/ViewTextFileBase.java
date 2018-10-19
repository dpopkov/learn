package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class ViewTextFileBase extends Application {
    private final String title;
    private final int width;
    private final int height;

    public ViewTextFileBase(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(getBorderPane(), width, height));
        primaryStage.setTitle(title);
        primaryStage.show();
    }

    public BorderPane getBorderPane() {
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        TextField tfPath = new TextField();
        Button btView = new Button("View");
        btView.setOnAction(e -> processFile(tfPath.getText()));
        hBox.getChildren().addAll(new Label("Filename:"), tfPath, btView);
        borderPane.setBottom(hBox);
        return borderPane;
    }

    protected abstract void processFile(String path);

    protected String readFile(String path) {
        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}
