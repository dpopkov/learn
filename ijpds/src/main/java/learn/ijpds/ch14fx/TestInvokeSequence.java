package learn.ijpds.ch14fx;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestInvokeSequence extends Application {
    public TestInvokeSequence() {
        System.out.println("TestInvokeSequence constructor is invoked");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("start method is invoked");
    }

    public static void main(String[] args) {
        System.out.println("launch application");
        Application.launch(args);
    }
}
