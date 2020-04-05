package learn.ijpds2nd.ch06methods.exer;

import java.util.function.IntConsumer;

class E0630CrapsGame {
    private final E0630Roller roller;
    private final IntConsumer sumPrinter;
    private boolean youWin;
    private boolean pointEstablished;
    private int point;

    public E0630CrapsGame(E0630Roller roller, IntConsumer sumPrinter) {
        this.roller = roller;
        this.sumPrinter = sumPrinter;
    }

    public boolean roll() {
        boolean goesOn = false;
        int sum = roller.roll();
        sumPrinter.accept(sum);
        if (pointEstablished) {
            if (sum == 7) {
                youWin = false;
            } else if (sum == point) {
                youWin = true;
            } else {
                goesOn = true;
            }
        } else {
            switch (sum) {
                case 2: case 3: case 12:
                    youWin = false;
                    break;
                case 7: case 11:
                    youWin = true;
                    break;
                default:
                    pointEstablished = true;
                    point = sum;
                    goesOn = true;
                    break;
            }
        }
        return goesOn;
    }

    public boolean youWin() {
        return youWin;
    }
}
