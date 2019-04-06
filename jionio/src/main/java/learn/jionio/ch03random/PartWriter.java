package learn.jionio.ch03random;

import java.io.DataOutput;
import java.io.IOException;

import static learn.jionio.ch03random.Part.*;

public class PartWriter {
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
