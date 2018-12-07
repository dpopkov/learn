package learn.core2.ch02io.regex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTesterGui extends Application {

    private TextField tfInput = new TextField();
    private TextField tfPattern = new TextField();
    private TextArea taOutput = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox(2);

        vBox.getChildren().addAll(tfInput, tfPattern);
        pane.setTop(vBox);

        pane.setCenter(taOutput);
        HBox hBox = new HBox(10);
        Button btEvaluate = new Button("Evaluate");
        btEvaluate.setOnAction(e -> evaluate());
        hBox.getChildren().addAll(btEvaluate);
        pane.setBottom(hBox);
        primaryStage.setScene(new Scene(pane, 320, 200));
        primaryStage.setTitle("RegexTesterGui");
        primaryStage.show();
    }

    private void evaluate() {
        String s = tfInput.getText();
        String p = tfPattern.getText();
        Pattern pattern = Pattern.compile(p, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            taOutput.setText(formatResult(s, matcher));
        } else {
            taOutput.setText("no match");
        }
    }

    private String formatResult(String input, Matcher matcher) {
        ResultBuilder builder = new ResultBuilder();
        builder.add("matches", matcher.matches());
        int groupCount = matcher.groupCount();
        builder.add("groupCount", groupCount);
        if (groupCount > 0) {
            builder.add(new MatchedFormatter(matcher).formatInGroups(input));
            for (int i = 1; i <= groupCount; i++) {
                builder.add("group #" + i
                        + "(" + matcher.start(i) + "," + matcher.end(i) + ")"
                        + ": '" + matcher.group(i) + "'");
            }
        }
        return builder.toString();
    }

    private static class ResultBuilder {
        private static final String NL = System.lineSeparator();

        private StringBuilder builder = new StringBuilder();

        public void add(String label, int n) {
            builder.append(label);
            builder.append(": ");
            builder.append(Integer.toString(n));
            builder.append(NL);
        }

        public void add(String label, boolean b) {
            builder.append(label);
            builder.append(": ");
            builder.append(Boolean.toString(b));
            builder.append(NL);
        }

        public void add(String line) {
            builder.append(line);
            builder.append(NL);
        }

        @Override
        public String toString() {
            return builder.toString();
        }
    }
}
