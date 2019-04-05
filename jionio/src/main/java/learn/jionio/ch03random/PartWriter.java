package learn.jionio.ch03random;

import java.io.DataOutput;
import java.io.IOException;

public class PartWriter {
    public static final int NUMBER_LEN = 20;
    public static final int DESC_LEN = 30;
    public static final int QTY_LEN = 4;
    public static final int COST_LEN = 4;
    public static final int RECORD_LEN = NUMBER_LEN + DESC_LEN + QTY_LEN + COST_LEN;

    public void write(DataOutput out, Part part) throws IOException {
        StringBuilder sb = new StringBuilder(part.getNumber());
        if (sb.length() > NUMBER_LEN) {
            sb.setLength(NUMBER_LEN);
        } else if (sb.length() < NUMBER_LEN) {
            sb.append(" ".repeat(NUMBER_LEN - sb.length()));
        }
        out.writeChars(sb.toString());
        sb.setLength(0);
        sb.append(part.getDescription());
        if (sb.length() > DESC_LEN) {
            sb.setLength(DESC_LEN);
        } else if (sb.length() < DESC_LEN) {
            sb.append(" ".repeat(DESC_LEN - sb.length()));
        }
        out.writeChars(sb.toString());
        out.writeInt(part.getQty());
        out.writeInt(part.getCost());
    }
}
