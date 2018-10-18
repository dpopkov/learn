/* 16.5 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E1605ConvertNumbers extends Application {
    private final IntegerTextField tfDec = new IntegerTextField(10);
    private final IntegerTextField tfHex = new IntegerTextField(16);
    private final IntegerTextField tfBin = new IntegerTextField(2);

    @Override
    public void start(Stage primaryStage) {
        tfDec.setOnAction(e -> convert(tfDec, tfHex, tfBin));
        tfHex.setOnAction(e -> convert(tfHex, tfDec, tfBin));
        tfBin.setOnAction(e -> convert(tfBin, tfDec, tfHex));
        primaryStage.setScene(new Scene(initGridPane(), 300, 150));
        primaryStage.setTitle("ConvertNumbers");
        primaryStage.show();
    }

    private GridPane initGridPane() {
        GridBuilder builder = new GridBuilder();
        builder.appendRow("Decimal", tfDec);
        builder.appendRow("Hex", tfHex);
        builder.appendRow("Binary", tfBin);
        return builder.getGrid();
    }

    private void convert(IntegerTextField source, IntegerTextField... destinations) {
        int value = source.getNumber();
        for (IntegerTextField destination : destinations) {
            destination.setNumber(value);
        }
    }
}
