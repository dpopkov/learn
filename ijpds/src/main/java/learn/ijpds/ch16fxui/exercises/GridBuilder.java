package learn.ijpds.ch16fxui.exercises;

import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridBuilder {
    private static final int GAP = 10;

    private int row;
    private final GridPane grid;

    public GridBuilder() {
        grid = new GridPane();
        grid.setVgap(GAP);
        grid.setHgap(GAP);
        grid.setPadding(new Insets(GAP));
    }

    public void appendRow(String labelText, Control control) {
        grid.add(new Label(labelText), 0, row);
        grid.add(control,1, row++);
    }

    public GridPane getGrid() {
        return grid;
    }
}
