/* 16.9 */
package learn.ijpds.ch16fxui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    private final String[] flagTitles = {"Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};
    private final ImageView[] imageViews = {
            new ImageView("image/ca.gif"),
            new ImageView("image/china.gif"),
            new ImageView("image/denmark.gif"),
            new ImageView("image/fr.gif"),
            new ImageView("image/germany.gif"),
            new ImageView("image/india.gif"),
            new ImageView("image/norway.gif"),
            new ImageView("image/uk.gif"),
            new ImageView("image/us.gif")};

    @Override
    public void start(Stage primaryStage) {
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagTitles));
        lv.setPrefSize(200, 300);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        FlowPane imagePane = new FlowPane(10, 10);
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(new ScrollPane(lv));
        mainPane.setCenter(imagePane);

        lv.getSelectionModel().selectedItemProperty().addListener(ov -> {
            imagePane.getChildren().clear();
            for (Integer i : lv.getSelectionModel().getSelectedIndices()) {
                imagePane.getChildren().add(imageViews[i]);
            }
        });

        Scene scene = new Scene(mainPane, 450, 170);
        primaryStage.setTitle("ListViewDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
