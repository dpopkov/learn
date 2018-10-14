package learn.ijpds.ch15events.exercises;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

import java.util.Collections;
import java.util.List;

public class RandomWalkPane extends Pane {
    private final int module;
    private final int stepsX;
    private final int stepsY;
    private final double height;
    private final double width;
    private final Polyline polyline;
    private int lastX;
    private int lastY;

    public RandomWalkPane(int moduleSize, int numStepsX, int numStepsY) {
        this.module = moduleSize;
        this.stepsX = numStepsX;
        this.stepsY = numStepsY;
        this.height = stepsY * module;
        this.width = stepsX * module;
        createGrid();

        polyline = new Polyline();
        initPolyline();
    }

    private void initPolyline() {
        polyline.setStrokeWidth(2);
        this.getChildren().add(polyline);
        initPolylinePoints();
    }

    private void initPolylinePoints() {
        lastX = stepsX / 2 * module;
        lastY = stepsY / 2 * module;
        polyline.getPoints().addAll((double)lastX, (double)lastY);
    }

    public void reset() {
        polyline.getPoints().clear();
        initPolylinePoints();
    }

    public boolean step() {
        boolean done = false;
        Direction dir = findDirection();
        if (dir != null) {
            lastX = stepX(lastX, dir);
            lastY = stepY(lastY, dir);
            polyline.getPoints().addAll((double) lastX, (double) lastY);
            done = true;
        }
        return done;
    }

    private Direction findDirection() {
        List<Direction> list = Direction.getMutableList();
        Collections.shuffle(list);
        Direction found = null;
        while (found == null && list.size() > 0) {
            Direction dir = list.get(list.size() - 1);
            int nextX = stepX(lastX, dir);
            int nextY = stepY(lastY, dir);
            if (selfIntersects(nextX, nextY) || !withinBorder(nextX, nextY)) {
                list.remove(list.size() - 1);
            } else {
                found = dir;
            }
        }
        return found;
    }

    private boolean withinBorder(int x, int y) {
        return 0 <= x && x <= width && 0 <= y && y <= height;
    }

    private int stepX(int x, Direction d) {
        return x + d.stepX(module);
    }

    private int stepY(int y, Direction d) {
        return y + d.stepY(module);
    }

    private boolean selfIntersects(int x, int y) {
        ObservableList<Double> points = polyline.getPoints();
        boolean intersects = false;
        for (int i = 0; !intersects && i < points.size() - 3; i += 2) {
            int x1 = points.get(i).intValue();
            int y1 = points.get(i + 1).intValue();
            int x2 = points.get(i + 2).intValue();
            int y2 = points.get(i + 3).intValue();
            if (x == x1 && y == y1 || x == x2 && y == y2) {
                intersects = true;
            } else if (x1 == x2 && x == x1) {
                if (y1 <= y && y <= y2 || y2 <= y && y <= y1)
                    intersects = true;

            } else if (y1 == y2 && y == y1) {
                if (x1 <= x && x <= x2 || x2 <= x && x <= x1) {
                    intersects = true;
                }
            }
        }
        return intersects;
    }

    private void createGrid() {
        double x = 0;
        for (int i = 0; i <= stepsX; i++, x += module) {
            Line line = new Line(x, 0, x, height);
            line.setStroke(Color.LIGHTGRAY);
            this.getChildren().add(line);
        }
        double y = 0;
        for (int i = 0; i <= stepsY; i++, y += module) {
            Line line = new Line(0, y, width, y);
            line.setStroke(Color.LIGHTGRAY);
            this.getChildren().add(line);
        }
    }
}
