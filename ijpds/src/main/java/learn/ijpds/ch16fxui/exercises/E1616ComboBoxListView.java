/*
16.16
Demonstrates selecting items in a list. Uses a combo box to specify a selection mode.
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.StringJoiner;

public class E1616ComboBoxListView extends Application {
    private final Label lblStatus = new Label();

    @Override
    public void start(Stage primaryStage) {
        ListView<String> lvCountries = new ListView<>(
                FXCollections.observableArrayList("China", "Japan", "Korea", "India", "Malaysia", "Vietnam"));
        lvCountries.getSelectionModel().selectedItemProperty().addListener(ov -> {
            StringJoiner joiner = new StringJoiner(", ", "[", "]");
            for (String s : lvCountries.getSelectionModel().getSelectedItems()) {
                joiner.add(s);
            }
            lblStatus.setText(joiner.toString());
        });
        ComboBox<SelectionMode> cbMode = new ComboBox<>();
        cbMode.getItems().addAll(SelectionMode.SINGLE, SelectionMode.MULTIPLE);
        cbMode.setValue(SelectionMode.SINGLE);
        cbMode.setOnAction(e -> lvCountries.getSelectionModel().setSelectionMode(cbMode.getValue()));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(cbMode);
        borderPane.setCenter(lvCountries);
        borderPane.setBottom(lblStatus);
        primaryStage.setScene(new Scene(borderPane, 400, 240));
        primaryStage.setTitle("ComboBoxListView");
        primaryStage.show();
    }
}
