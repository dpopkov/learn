package learn.ijpds.ch16fxui.exercises;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Displays hours, minutes and seconds in HH:MM:SS format and
 * updates this representation for one second when invalidated.
 */
public class TimeLabelBox extends HBox implements InvalidationListener {
    private static final int DEFAULT_FONT_SIZE = 36;

    private final Text txHoursMinutes = new Text();
    private final Text txSeconds = new Text();
    private int hours;
    private int minutes;
    private int seconds;

    public TimeLabelBox() {
        this(0, 0, 0, DEFAULT_FONT_SIZE);
    }

    public TimeLabelBox(int hours, int minutes, int seconds, int fontSize) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        setAlignment(Pos.CENTER);
        String family = txHoursMinutes.getFont().getFamily();
        Font font = Font.font(family, FontWeight.NORMAL, FontPosture.REGULAR, fontSize);
        txHoursMinutes.setFont(font);
        txSeconds.setFont(font);
        getChildren().addAll(txHoursMinutes, txSeconds);
        updateHoursMinutes();
        updateSeconds();
    }

    /**
     * Resets hours, minutes and seconds to 0.
     */
    public void reset() {
        hours = 0;
        minutes = 0;
        seconds = 0;
        updateHoursMinutes();
        updateSeconds();
    }

    private void updateSeconds() {
        txSeconds.setText(formatSS());
    }

    private void updateHoursMinutes() {
        txHoursMinutes.setText(formatHHMM());
    }

    private String formatHHMM() {
        return String.format("%02d:%02d:", hours, minutes);
    }

    private String formatSS() {
        return String.format("%02d", seconds);
    }

    /**
     * Updates time representation for one second.
     * @param observable observable object (not used in the method)
     */
    @Override
    public void invalidated(Observable observable) {
        seconds++;
        if (seconds == 60) {
            minutes++;
            seconds = 0;
            if (minutes == 60) {
                hours++;
                minutes = 0;
            }
            updateHoursMinutes();
        }
        updateSeconds();
    }
}
