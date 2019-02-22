package learn.hackerrank.java.practice;

public class AscendingSequence {
    private int start;
    private int end;

    public void find(int[] numbers) {
        if (numbers.length == 1) {
            return;
        }
        int newStart = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] >= numbers[i]) {
                newStart = i;
            }
            if (i - newStart >= end - start) {
                start = newStart;
                end = i;
            }
        }
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
