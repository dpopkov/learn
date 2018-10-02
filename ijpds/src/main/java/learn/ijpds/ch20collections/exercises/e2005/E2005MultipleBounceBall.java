package learn.ijpds.ch20collections.exercises.e2005;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E2005MultipleBounceBall extends Application {

    @Override
    public void start(Stage primaryStage) {
        E2005MultipleBallPane ballPane = new E2005MultipleBallPane();
        ballPane.setStyle("−fx−border−color: yellow");

        Button btnSuspend = new Button("Suspend");
        Button btnResume = new Button("Resume");
        Button btnAdd = new Button("+");
        Button btnSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btnSuspend, btnResume, btnAdd, btnSubtract);
        hBox.setAlignment(Pos.CENTER);

        btnSuspend.setOnAction(e -> ballPane.pause());
        btnResume.setOnAction(e -> ballPane.play());
        btnAdd.setOnAction(e -> ballPane.add());
        btnSubtract.setOnAction(e -> ballPane.subtract());

        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(30);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("E2005MultipleBounceBall");
        primaryStage.setScene(scene);
        primaryStage.show();
        ballPane.requestFocus();
    }
}
