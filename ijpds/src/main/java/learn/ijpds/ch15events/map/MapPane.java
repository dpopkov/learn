/* 15.19 */
package learn.ijpds.ch15events.map;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapPane extends BorderPane {
    private final Group group = new Group();

    public MapPane() {
        List<List<Point2D>> points = getPoints();
        for (List<Point2D> subList : points) {
            Polygon polygon = new Polygon();
            for (Point2D point : subList) {
                polygon.getPoints().addAll(point.getX(), -point.getY());
            }
            polygon.setFill(Color.WHITE);
            polygon.setStroke(Color.BLACK);
            polygon.setStrokeWidth(1 / 14.0);
            polygon.setOnMouseClicked(e -> {
                switch (e.getButton()) {
                    case PRIMARY: polygon.setFill(Color.RED); break;
                    case SECONDARY: polygon.setFill(Color.BLUE); break;
                    default: polygon.setFill(Color.WHITE); break;
                }
            });
            group.getChildren().add(polygon);
        }
        group.setScaleX(14);
        group.setScaleY(14);
        this.setCenter(group);
    }

    public void enlarge() {
        group.setScaleX(1.1 * group.getScaleX());
        group.setScaleY(1.1 * group.getScaleY());
    }

    public void shrink() {
        group.setScaleX(0.9 * group.getScaleX());
        group.setScaleY(0.9 * group.getScaleY());
    }

    private List<List<Point2D>> getPoints() {
        List<List<Point2D>> points = new ArrayList<>();
        File file = new File("io/text/usmap.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String s = input.nextLine();
                if (Character.isAlphabetic(s.charAt(0))) {
                    points.add(new ArrayList<>());
                } else {
                    Scanner scan = new Scanner(s);
                    double y = scan.nextDouble();
                    double x = scan.nextDouble();
                    points.get(points.size() - 1).add(new Point2D(x, y));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return points;
    }
}
