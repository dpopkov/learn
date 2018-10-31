/*
17.20
Binary editor.
Lets the user to enter a file name and press the Enter key to display its binary representation.
The user can modify the binary code and save it back to the file.
 */
package learn.ijpds.ch17io.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;

public class BaseFileEditor extends Application {
    private ContentPresenter contentPresenter;
    private final TextField txPath = new TextField();
    private final TextArea txContent = new TextArea();
    private String title;

    public void setContentPresenter(ContentPresenter contentPresenter) {
        this.contentPresenter = contentPresenter;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(createTopPane());
        borderPane.setCenter(txContent);
        borderPane.setBottom(createBottomPane());
        primaryStage.setScene(new Scene(borderPane, 400, 200));
        primaryStage.setTitle(title);
        primaryStage.show();
    }

    private HBox createTopPane() {
        HBox topPane = new HBox(10);
        topPane.setPadding(new Insets(10));
        txPath.setPrefColumnCount(20);
        txPath.setOnAction(e -> readFile(txPath.getText()));
        topPane.getChildren().addAll(new Label("Enter a file"), txPath);
        return topPane;
    }

    private HBox createBottomPane() {
        HBox bottomPane = new HBox(10);
        bottomPane.setPadding(new Insets(10));
        bottomPane.setAlignment(Pos.CENTER);
        Button btSave = new Button("Save the change");
        btSave.setOnAction(e -> saveContentToFile(txContent.getText().trim(), txPath.getText()));
        bottomPane.getChildren().add(btSave);
        return bottomPane;
    }

    private void saveContentToFile(String content, String path) {
        byte[] bytes = contentPresenter.toBytes(content);
        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path))) {
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String path) {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(path))) {
            String content = contentPresenter.getFromStream(input);
            txContent.setText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
