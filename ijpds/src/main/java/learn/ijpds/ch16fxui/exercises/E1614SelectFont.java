/*
16.14
Dynamically change the font of a text in a label.
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1614SelectFont extends Application {
    private final Text text = new Text("Programming is fun");
    private final ComboBox<String> cbFonts = new ComboBox<>();
    private final ComboBox<Integer> cbSizes = new ComboBox<>();
    private final CheckBox cbxBold = new CheckBox("Bold");
    private final CheckBox cbxItalic = new CheckBox("Italic");

    @Override
    public void start(Stage primaryStage) {
        EventHandler<ActionEvent> formatHandler = e -> reformatText();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(initTopPane(formatHandler));
        borderPane.setCenter(new StackPane(text));
        borderPane.setBottom(initBottomPane(formatHandler));
        setCurrentFormattingParameters();
        primaryStage.setScene(new Scene(borderPane, 600, 200));
        primaryStage.setTitle("Select a font");
        primaryStage.show();
    }

    private void reformatText() {
        Font font = Font.font(
                cbFonts.getSelectionModel().getSelectedItem(),
                cbxBold.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL,
                cbxItalic.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR,
                cbSizes.getSelectionModel().getSelectedItem().doubleValue());
        text.setFont(font);
    }

    private void setCurrentFormattingParameters() {
        Font current = text.getFont();
        cbFonts.getSelectionModel().select(current.getFamily());
        cbSizes.getSelectionModel().select(Integer.valueOf((int)current.getSize()));
    }

    private HBox initTopPane(EventHandler<ActionEvent> formatHandler) {
        HBox topPane = new HBox(10);
        topPane.setPadding(new Insets(10));
        cbFonts.getItems().addAll(Font.getFontNames());
        for (int i = 1; i <= 100; i++) {
            cbSizes.getItems().add(i);
        }
        cbFonts.setOnAction(formatHandler);
        cbSizes.setOnAction(formatHandler);
        topPane.getChildren().addAll(new Label("Font Name"), cbFonts,
                new Label("Font Size"), cbSizes);
        return topPane;
    }

    private HBox initBottomPane(EventHandler<ActionEvent> formatHandler) {
        HBox bottomPane = new HBox(10);
        bottomPane.setPadding(new Insets(10));
        cbxBold.setOnAction(formatHandler);
        cbxItalic.setOnAction(formatHandler);
        bottomPane.getChildren().addAll(cbxBold, cbxItalic);
        return bottomPane;
    }
}
