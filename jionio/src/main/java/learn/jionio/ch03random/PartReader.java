package learn.jionio.ch03random;

import java.io.DataInput;
import java.io.IOException;

public class PartReader {
    public Part read(DataInput in) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Part.NUMBER_LEN; i++) {
            builder.append(in.readChar());
        }
        String partNum = builder.toString().trim();
        builder.setLength(0);
        for (int i = 0; i < Part.DESC_LEN; i++) {
            builder.append(in.readChar());
        }
        String partDesc = builder.toString().trim();
        int qty = in.readInt();
        int cost = in.readInt();
        return new Part(partNum, partDesc, qty, cost);
    }
}
