/* 16.8 */
package learn.ijpds.ch16fxui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {
    private final String[] flagTitles = {"Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};
    private final ImageView[] flagImage = {
            new ImageView("image/ca.gif"),
            new ImageView("image/china.gif"),
            new ImageView("image/denmark.gif"),
            new ImageView("image/fr.gif"),
            new ImageView("image/germany.gif"),
            new ImageView("image/india.gif"),
            new ImageView("image/norway.gif"),
            new ImageView("image/uk.gif"),
            new ImageView("image/us.gif")};
    private final String[] flagDescription = new String[9];
    {
        flagDescription[0] = "The Canadian national flag ... ";
        flagDescription[1] = "Description for China ... ";
        flagDescription[2] = "Description for Denmark ... ";
        flagDescription[3] = "Description for France ... ";
        flagDescription[4] = "Description for Germany ... ";
        flagDescription[5] = "Description for India ... ";
        flagDescription[6] = "Description for Norway ... ";
        flagDescription[7] = "Description for UK ... ";
        flagDescription[8] = "Description for US ... ";
    }
    private final DescriptionPane descriptionPane = new DescriptionPane();
    private final ComboBox<String> cbo = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        setDisplay(0);

        BorderPane cboPane = new BorderPane();
        cboPane.setLeft(new Label("Select a country: "));
        cboPane.setCenter(cbo);

        cbo.setPrefWidth(400);
        cbo.setValue("Canada");
        ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
        cbo.getItems().addAll(items);
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

        BorderPane mainPane = new BorderPane();
        mainPane.setTop(cboPane);
        mainPane.setCenter(descriptionPane);

        Scene scene = new Scene(mainPane, 450, 170);
        primaryStage.setTitle("ComboBoxDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setDisplay(int index) {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }
}
