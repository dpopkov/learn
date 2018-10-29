package learn.ijpds.ch17io.exercises;

import learn.ijpds.tools.BitsTools;

import java.io.*;

public class E1717BitOutputStream {
    public static void main(String[] args) throws IOException {
        final String path = "io/data/e_17_17.dat";

        /* Writing */
        try (BitOutputStream output = new BitOutputStream(new File(path))) {
            output.writeBits("010000100100001001101");
        }
        System.out.println("Writing to BitOutputStream finished.");

        /* Reading */
        try (DataInputStream input = new DataInputStream(new FileInputStream(path))) {
            boolean reading = true;
            while (reading) {
                try {
                    byte b = input.readByte();
                    System.out.println(BitsTools.toBinary(b));
                } catch (EOFException e) {
                    reading = false;
                }
            }
        }
    }
}
