package learn.ijpds.ch16fxui.exercises;

import javafx.scene.control.TextField;

public class DoubleTextField extends TextField {

    public DoubleTextField(int columnCount) {
        this.setPrefColumnCount(columnCount);
    }

    public double getNumber() {
        return Double.parseDouble(super.getText());
    }

    public void setNumber(double number) {
        super.setText(Double.toString(number));
    }
}
