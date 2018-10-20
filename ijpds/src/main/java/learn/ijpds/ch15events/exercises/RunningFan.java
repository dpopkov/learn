package learn.ijpds.ch15events.exercises;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class RunningFan extends StackPane {
    private static final int GAP = 5;
    private static final int NUM_VANES = 6;
    private static final int NUM_ROTATIONS = 100;

    private final RotateTransition animation;

    public RunningFan(int diameter) {
        final int radius = diameter / 2;
        Circle circle = new Circle(radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        Group group = new Group();
        final int arcRadius = radius - GAP;
        for (int i = 0, start = 26; i < NUM_VANES; i++, start += 60) {
            Arc a1 = new Arc(centerX, centerY, arcRadius, arcRadius, start, 38);
            a1.setType(ArcType.ROUND);
            a1.setFill(i % 2 == 0 ? Color.BLACK : Color.GRAY);
            group.getChildren().add(a1);
        }
        getChildren().add(group);

        animation = initAnimation(group);
        animation.play();
    }

    private RotateTransition initAnimation(Group group) {
        RotateTransition rt = new RotateTransition();
        rt.setNode(group);
        rt.setDuration(Duration.millis(1000 * NUM_ROTATIONS));
        rt.setToAngle(360 * NUM_ROTATIONS);
        rt.setCycleCount(Timeline.INDEFINITE);
        return rt;
    }

    public void pause() { animation.pause(); }

    public void play() { animation.play(); }

    /**
     * Sets speed of animation where value of 1.0 is normal speed.
     * @param speedFactor speed factor
     */
    public void setSpeed(double speedFactor) {
        animation.setRate(speedFactor);
    }
}
