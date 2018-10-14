/*
15.34
Self-avoiding random walk - a path from one point to another that does not visit the same point twice.
Displays a random path that starts from the center and ends at a point on the boundary,
or ends at a dead-end point.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E1534RandomWalk extends Application {

    @Override
    public void start(Stage primaryStage) {
        RandomWalkPane walkPane = new RandomWalkPane(20, 30, 20);
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        Button btStep = new Button("Step");
        btStep.setOnAction(e -> {
            boolean moved = walkPane.step();
            if (!moved) {
                btStep.setDisable(true);
            }
        });
        Button btReset = new Button("Reset");
        btReset.setOnAction(e -> {
            walkPane.reset();
            btStep.setDisable(false);
        });
        hBox.getChildren().addAll(btStep, btReset);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(walkPane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("RandomWalk");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
