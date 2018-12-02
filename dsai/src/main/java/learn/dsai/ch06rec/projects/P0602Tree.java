package learn.dsai.ch06rec.projects;

import learn.dsai.tools.MathTools;

/*
In binary tree every branch has two sub-branches.
We might have 1 branch on the top row, 2 on the next row,
then 4, 8, 16, and so on.
Example for a tree 16 characters wide:
--------X-------
----X-------X---
--X---X---X---X-
-X-X-X-X-X-X-X-X
XXXXXXXXXXXXXXXX
 */
public class P0602Tree {
    private char[][] buffer;

    /**
     * Outputs the character representation of the tree to the specified consumer.
     * @param width width of the tree (number of characters)
     * @return the character representation of the tree
     */
    public String makeBranches(int width) {
        int height = MathTools.log2OfPowerOf2(width) + 1;
        buffer = new char[height][width];
        makeBranches(0,0, width - 1);
        return flushBuffer();
    }

    /**
     * Draws branches of the tree recursively.
     * @param left left endpoint
     * @param right right endpoint (inclusive)
     */
    private void makeBranches(int row, int left, int right) {
        if (left == right) {
            buffer[row][left] = 'X';
            return;
        }
        int xPos = (left + right) / 2 + 1;
        emptySpace(row, left, xPos);
        buffer[row][xPos] = 'X';
        emptySpace(row, xPos + 1, right + 1);
        makeBranches(row + 1, left, xPos - 1);
        makeBranches(row + 1, xPos, right);
    }

    private void emptySpace(int row, int from, int to) {
        char[] rowArray = buffer[row];
        for (int i = from; i < to; i++) {
            rowArray[i] = '-';
        }
    }

    private String flushBuffer() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < buffer.length; row++) {
            if (row > 0) {
                builder.append(System.lineSeparator());
            }
            builder.append(new String(buffer[row]));
        }
        return builder.toString();
    }
}
