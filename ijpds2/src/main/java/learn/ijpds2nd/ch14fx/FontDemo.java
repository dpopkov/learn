package learn.ijpds2nd.ch14fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;
import java.util.Scanner;

/* Listing 14.8 augmented */
public class FontDemo extends Application {
    private static String fontName;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new StackPane();
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
        pane.getChildren().add(circle);
        Label label = new Label("JavaFX");
        label.setFont(Font.font(fontName, FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane.getChildren().add(label);
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle(FontDemo.class.getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        setupFontName();
        launch(args);
    }

    private static void setupFontName() {
        List<String> fontNames = Font.getFontNames();
        int count = 0;
        for (String name : fontNames) {
            System.out.printf("%s : %d%n", name, count++);
        }
        System.out.println("-----------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of font name: ");
        int n = scanner.nextInt();
        fontName = fontNames.get(n);
        System.out.println("Using font name: " + fontName);
    }
}
