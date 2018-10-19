/* 16.10 */
package learn.ijpds.ch16fxui.exercises;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class E1610TextViewer extends ViewTextFileBase {
    private final TextArea textArea = new TextArea();

    public E1610TextViewer() {
        super("TextViewer", 380, 300);
    }

    @Override
    public BorderPane getBorderPane() {
        BorderPane borderPane = super.getBorderPane();
        borderPane.setCenter(textArea);
        return borderPane;
    }

    @Override
    protected void processFile(String path) {
        String text = super.readFile(path);
        textArea.setText(text);
    }
}
