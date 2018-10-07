/* 15.6 */
package learn.ijpds.ch15events;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import learn.ijpds.ch10oop.Loan;

public class LoanCalculator extends Application {
    private final TextField tfAnnualInterestRate = new TextField();
    private final TextField tfNumberOfYears = new TextField();
    private final TextField tfLoanAmount = new TextField();
    private final TextField tfMonthlyPayment = new TextField();
    private final TextField tfTotalPayment = new TextField();
    private final Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10));
        addRow(pane, "Annual Interest Rate:", tfAnnualInterestRate, 0);
        addRow(pane, "Number of Years:", tfNumberOfYears, 1);
        addRow(pane, "Loan Amount:", tfLoanAmount, 2);
        addRow(pane, "Monthly Payment:", tfMonthlyPayment, 3);
        addRow(pane, "Total Payment:", tfTotalPayment, 4);
        pane.add(btCalculate, 1, 5);
        pane.setAlignment(Pos.CENTER);
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        btCalculate.setOnAction(e -> calculateLoanPayment());

        Scene scene = new Scene(pane);
        primaryStage.setTitle("LoanCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addRow(GridPane pane, String label, TextField textField, int row) {
        textField.setAlignment(Pos.BOTTOM_RIGHT);
        pane.add(new Label(label), 0, row);
        pane.add(textField, 1, row);
    }

    private void calculateLoanPayment() {
        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int year = Integer.parseInt(tfNumberOfYears.getText());
        double loanAmount = Double.parseDouble(tfLoanAmount.getText());
        Loan loan = new Loan(interest, year, loanAmount);
        tfMonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
    }
}
