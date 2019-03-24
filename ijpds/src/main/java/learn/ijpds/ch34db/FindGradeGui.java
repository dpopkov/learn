package learn.ijpds.ch34db;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class FindGradeGui extends Application {
    private GradeReader findGrade;
    private final TextField tfSSN = new TextField();
    private final TextField tfCourseId = new TextField();
    private final Label lblStatus = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {
        findGrade = new FindGradeWithPreparedStmt();
        Button btShowGrade = new Button("Show Grade");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("SSN"), tfSSN, new Label("Course ID"), tfCourseId, btShowGrade);
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, lblStatus);

        tfSSN.setPrefColumnCount(9);
        tfCourseId.setPrefColumnCount(6);
        btShowGrade.setOnAction(e -> showGrade());

        primaryStage.setTitle("FindGrade");
        primaryStage.setScene(new Scene(vBox, 480, 80));
        primaryStage.show();
    }

    private void showGrade() {
        String ssn = tfSSN.getText();
        String courseId = tfCourseId.getText();
        try {
            String result = findGrade.readGrade(ssn, courseId);
            lblStatus.setText(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
