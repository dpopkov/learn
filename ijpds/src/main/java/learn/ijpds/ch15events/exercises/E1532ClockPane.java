/* 14.21 */
package learn.ijpds.ch15events.exercises;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.util.Duration;
import learn.ijpds.ch14fx.clock.ClockPane;

import java.util.ArrayList;
import java.util.List;

public class E1532ClockPane extends ClockPane implements Observable {
    private final Timeline animation;
    private final List<InvalidationListener> listeners = new ArrayList<>();

    /**
     * Creates clock for the current time.
     */
    public E1532ClockPane() {
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            setCurrentTime();
            fireTickEvent();
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        animation.play();
    }

    public void stop() {
        animation.pause();
    }

    private void fireTickEvent() {
        for (InvalidationListener listener : listeners) {
            listener.invalidated(this);
        }
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listeners.remove(listener);
    }
}

