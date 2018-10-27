package learn.ijpds.ch17io.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import learn.ijpds.ch16fxui.exercises.GridBuilder;

import java.io.IOException;

public class E1709AddressBookGUI extends Application {
    private final TextField txName = new TextField();
    private final TextField txStreet = new TextField();
    private final TextField txCity = new TextField();
    private final TextField txState = new TextField();
    private final TextField txZip = new TextField();
    private E1709AddressBook addressBook;
    private int currentIndex;

    public E1709AddressBookGUI() {
        txState.setPrefColumnCount(2);
        txZip.setPrefColumnCount(5);
        try {
            addressBook = new E1709AddressBook();
        } catch (IOException e) {
            displayError(e);
        }
    }

    private void setAddress(Address address) {
        txName.setText(address.getName());
        txStreet.setText(address.getStreet());
        txCity.setText(address.getCity());
        txState.setText(address.getState());
        txZip.setText(address.getZip());
    }

    private Address getAddress() {
        return new Address(txName.getText(), txStreet.getText(), txCity.getText(), txState.getText(), txZip.getText());
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(createGridPane());
        borderPane.setBottom(createButtonsPane());
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("AddressBook");
        primaryStage.setOnCloseRequest(event -> {
            try {
                addressBook.close();
            } catch (Exception e) {
                displayError(e);
            }
        });
        primaryStage.show();
        showFirst();
    }

    private GridPane createGridPane() {
        GridBuilder builder = new GridBuilder();
        builder.appendRow("Name", txName);
        builder.appendRow("Street", txStreet);
        HBox bottomRow = new HBox(10);
        bottomRow.setAlignment(Pos.CENTER_LEFT);
        bottomRow.getChildren().addAll(txCity, new Label("State"), txState, new Label("Zip"), txZip);
        builder.appendRow("City", bottomRow);
        return builder.getGrid();
    }

    private HBox createButtonsPane() {
        HBox ane = new HBox(10);
        ane.setPadding(new Insets(10));
        ane.setAlignment(Pos.CENTER);
        Button btAdd = new Button("Add");
        btAdd.setOnAction(e -> addAddress());
        Button btFirst = new Button("First");
        btFirst.setOnAction(e -> showFirst());
        Button btNext = new Button("Next");
        btNext.setOnAction(e -> showNext());
        Button btPrev = new Button("Prev");
        btPrev.setOnAction(e -> showPrev());
        Button btLast = new Button("Last");
        btLast.setOnAction(e -> showLast());
        Button btUpdate = new Button("Update");
        btUpdate.setOnAction(e -> updateCurrent());
        ane.getChildren().addAll(btAdd, btFirst, btNext, btPrev, btLast, btUpdate);
        return ane;
    }

    private void showLast() {
        Address address = addressBook.getLast();
        if (address != null) {
            setAddress(address);
            currentIndex = addressBook.size() - 1;
        }
    }

    private void showFirst() {
        Address address = addressBook.getFirst();
        if (address != null) {
            setAddress(address);
            currentIndex = 0;
        }
    }

    private void showNext() {
        if (currentIndex + 1 < addressBook.size()) {
            Address address = addressBook.get(++currentIndex);
            setAddress(address);
        }
    }

    private void showPrev() {
        if (currentIndex > 0) {
            Address address = addressBook.get(--currentIndex);
            setAddress(address);
        }
    }

    private void updateCurrent() {
        Address address = getAddress();
        try {
            addressBook.set(currentIndex, address);
        } catch (IOException e) {
            displayError(e);
        }
    }

    private void addAddress() {
        Address address = getAddress();
        try {
            addressBook.add(address);
            currentIndex = addressBook.size() - 1;
        } catch (IOException e) {
            displayError(e);
        }
    }

    private void displayError(Exception e) {
        e.printStackTrace();
    }
}
