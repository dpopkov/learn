package learn.dsajg6e.ch05recursion;

import learn.dsajg6e.tools.Input;

public class EnglishRuler {
    private static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);
        for (int i = 1; i <= nInches; i++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, i);
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }

    private static void drawLine(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++) {
            System.out.print("-");
        }
        if (tickLabel >= 0) {
            System.out.print(" " + tickLabel);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nInches = Input.nextInt("Number of inches: ");
        int majorLength = Input.nextInt("Major length: ");
        drawRuler(nInches, majorLength);
    }
}
