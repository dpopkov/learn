package learn.ijpds.ch15events.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Direction {
    RIGHT(1, 0), LEFT(-1, 0), UP(0, -1), DOWN(0, 1);

    private final int deltaX;
    private final int deltaY;

    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int stepX(int stepLength) {
        return this.deltaX * stepLength;
    }

    public int stepY(int stepLength) {
        return this.deltaY * stepLength;
    }

    public static List<Direction> getMutableList() {
        return new ArrayList<Direction>(Direction.values().length) {
            {
                this.addAll(Arrays.asList(Direction.values()));
            }
        };
    }
}
