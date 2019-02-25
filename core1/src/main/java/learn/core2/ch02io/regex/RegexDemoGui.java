package learn.core2.ch02io.regex;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
VM options JavaFX:
--module-path c:\path-to-javafx\javafx-sdk-11\lib
--add-modules=javafx.controls,javafx.fxml
 */
public class RegexDemoGui extends Application {
    private final MatcherFormatter formatter = new MatcherFormatter();
    private final TextArea textArea = new TextArea();
    private TextField tfPattern;
    private TextField tfString;
    private Pattern pattern;

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        tfPattern = new TextField();
        tfPattern.setOnAction(e -> recompilePattern());
        tfString = new TextField();
        tfString.setOnAction(e -> displayMatch());
        Button btRecompile = new Button("Recompile");
        Button btMatch = new Button("Match");
        btRecompile.setOnAction(e -> recompilePattern());
        btMatch.setOnAction(e -> displayMatch());
        gridPane.addColumn(0, new Label("Pattern:"), new Label("String:"));
        gridPane.addColumn(1, tfPattern, tfString);
        gridPane.addColumn(2, btRecompile, btMatch);
        pane.setTop(gridPane);
        pane.setCenter(new ScrollPane(textArea));
        primaryStage.setTitle("RegexDemo");
        primaryStage.setScene(new Scene(pane, 300, 200));
        primaryStage.show();
    }

    private void displayMatch() {
        String input = tfString.getText().trim();
        Matcher matcher = pattern.matcher(input);
        textArea.appendText(formatter.format(matcher, input) + '\n');
    }

    private void recompilePattern() {
        pattern = Pattern.compile(tfPattern.getText().trim());
    }
}
