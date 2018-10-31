/*
17.20
Binary editor.
Lets the user to enter a file name and press the Enter key to display its binary representation.
The user can modify the binary code and save it back to the file.
 */
package learn.ijpds.ch17io.exercises;

import javafx.stage.Stage;

public class E1720BinaryEditor extends BaseFileEditor {
    @Override
    public void start(Stage primaryStage) {
        setContentPresenter(new BinaryContentPresenter(8));
        setTitle("Binary Editor");
        super.start(primaryStage);
    }
}
