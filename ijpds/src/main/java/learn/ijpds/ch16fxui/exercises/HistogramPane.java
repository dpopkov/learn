package learn.ijpds.ch16fxui.exercises;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class HistogramPane<T> extends Pane {
    private static final int GAP = 4;
    private static final int MARGIN = 10;
    private static final int BAR_WIDTH = 8;
    private static final int BAR_STEP = BAR_WIDTH + GAP;
    private static final int MAX_BAR_HEIGHT = 200;
    private static final int TEXT_HEIGHT = 20;
    private static final int BASE_Y = MARGIN + MAX_BAR_HEIGHT;
    private static final int TEXT_Y = BASE_Y + TEXT_HEIGHT;

    private Map<T, Integer> data;
    private final Color barColor;

    public HistogramPane(Color barColor) {
        this.barColor = barColor;
    }

    public HistogramPane(Map<T, Integer> data, Color barColor) {
        this.data = data;
        this.barColor = barColor;
        drawHistogram();
    }

    public void setData(Map<T, Integer> data) {
        this.data = data;
        drawHistogram();
    }

    public void drawHistogram() {
        getChildren().clear();
        Collection<Integer> values = data.values();
        double heightFactor = (double)MAX_BAR_HEIGHT / Collections.max(values);
        int currentX = MARGIN;
        for (T label : data.keySet()) {
            getChildren().add(new Text(currentX, TEXT_Y, label.toString()));
            getChildren().add(createBar(currentX, data.get(label) * heightFactor));
            currentX += BAR_STEP;
        }
        int endX = MARGIN + values.size() * BAR_STEP;
        Line axis = new Line(MARGIN, BASE_Y, endX, BASE_Y);
        getChildren().add(axis);
    }

    private Rectangle createBar(double x, double barHeight) {
        Rectangle bar = new Rectangle(x, BASE_Y - barHeight, BAR_WIDTH, barHeight);
        bar.setFill(barColor);
        return bar;
    }
}
