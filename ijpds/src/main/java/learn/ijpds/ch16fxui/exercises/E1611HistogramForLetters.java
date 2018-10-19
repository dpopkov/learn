/*
16.11
Create a histogram for occurrences of letters.
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.Map;
import java.util.TreeMap;

public class E1611HistogramForLetters extends ViewTextFileBase {
    private HistogramPane<Character> histogramPane;
    private boolean ignoreCase;

    public E1611HistogramForLetters() {
        super("HistogramForLetters", 400, 320);
    }

    @Override
    public BorderPane getBorderPane() {
        BorderPane borderPane = super.getBorderPane();
        histogramPane = new HistogramPane<>(Color.LIGHTGREEN);
        borderPane.setTop(initTopPane());
        borderPane.setCenter(histogramPane);
        return borderPane;
    }

    private HBox initTopPane() {
        HBox topPane = new HBox(10);
        topPane.setPadding(new Insets(10));
        CheckBox cbxIgnoreCase = new CheckBox("Ignore Case");
        cbxIgnoreCase.setOnAction(e -> ignoreCase = cbxIgnoreCase.isSelected());
        topPane.getChildren().add(cbxIgnoreCase);
        return topPane;
    }

    @Override
    protected void processFile(String path) {
        String text = super.readFile(path);
        Map<Character, Integer> data = calculateOccurrences(text, ignoreCase);
        histogramPane.setData(data);
    }

    private Map<Character, Integer> calculateOccurrences(String text, boolean ignoreCase) {
        Map<Character, Integer> data = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if (ignoreCase) {
                    ch = Character.toLowerCase(ch);
                }
                Integer count = data.get(ch);
                data.put(ch, (count == null) ? 1 : count + 1);
            }
        }
        return data;
    }
}
