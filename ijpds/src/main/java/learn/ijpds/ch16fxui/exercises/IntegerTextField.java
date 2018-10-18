package learn.ijpds.ch16fxui.exercises;

import javafx.scene.control.TextField;

public class IntegerTextField extends TextField {

    private final int radix;

    public IntegerTextField(int radix) {
        this.radix = radix;
    }

    public IntegerTextField(int radix, int columnCount) {
        this.radix = radix;
        this.setPrefColumnCount(columnCount);
    }

    public int getNumber() {
        return Integer.parseInt(super.getText(), radix);
    }

    public void setNumber(int number) {
        super.setText(Integer.toString(number, radix));
    }
}
