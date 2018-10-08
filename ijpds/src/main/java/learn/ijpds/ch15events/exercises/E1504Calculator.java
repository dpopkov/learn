/*
15.4
Simple calculator performs addition, subtraction, multiplication, and division.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

@SuppressWarnings("SameParameterValue")
public class E1504Calculator extends Application {

    private final DoubleCalculator calculator = new DoubleCalculator();
    private TextField tfOperand1;
    private TextField tfOperand2;
    private TextField tfResult;

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setTop(createTopBox());
        pane.setBottom(createBottomBox());
        Scene scene = new Scene(pane);
        primaryStage.setTitle("SimpleCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createTopBox() {
        HBox top = createBox(5);
        tfOperand1 = createTextField(7);
        tfOperand2 = createTextField(7);
        tfResult = createTextField(7);
        tfResult.setEditable(false);
        top.getChildren().addAll(new Label("Number 1:"), tfOperand1,
                new Label("Number 2:"), tfOperand2,
                new Label("Result:"), tfResult);
        return top;
    }

    private HBox createBottomBox() {
        HBox bottom = createBox(5);
        bottom.setAlignment(Pos.CENTER);
        Button btAdd = new Button("Add");
        Button btSubtract = new Button("Subtract");
        Button btMultiply = new Button("Multiply");
        Button btDivide = new Button("Divide");
        btAdd.setOnAction(e -> calculate(ArithmeticOperation.ADD));
        btSubtract.setOnAction(e -> calculate(ArithmeticOperation.SUBTRACT));
        btMultiply.setOnAction(e -> calculate(ArithmeticOperation.MULTIPLY));
        btDivide.setOnAction(e -> calculate(ArithmeticOperation.DIVIDE));
        bottom.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
        return bottom;
    }

    private void calculate(ArithmeticOperation operation) {
        double op1 = Double.parseDouble(tfOperand1.getText());
        double op2 = Double.parseDouble(tfOperand2.getText());
        double result = calculator.calculate(op1, op2, operation);
        tfResult.setText(Double.toString(result));
    }

    private static TextField createTextField(int columns) {
        TextField tf1 = new TextField();
        tf1.setPrefColumnCount(columns);
        return tf1;
    }

    private static HBox createBox(int spacing) {
        HBox box = new HBox(spacing);
        box.setPadding(new Insets(spacing));
        return box;
    }
}
