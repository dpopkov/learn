/* 15.19 */
package learn.ijpds.ch15events.map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StateMap extends Application {
    @Override
    public void start(Stage primaryStage) {
        MapPane map = new MapPane();
        Scene scene = new Scene(map, 1200, 800);
        primaryStage.setTitle("StateMap");
        primaryStage.setScene(scene);
        primaryStage.show();

        map.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP: map.enlarge(); break;
                case DOWN: map.shrink(); break;
            }
        });
        map.requestFocus();
    }
}
