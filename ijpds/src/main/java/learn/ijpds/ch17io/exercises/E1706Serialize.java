package learn.ijpds.ch17io.exercises;

import learn.ijpds.ch10oop.Loan;

import java.io.*;

public class E1706Serialize {
    public static void main(String[] args) throws IOException {
        String path = "io/data/e_17_06.dat";
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (int i = 1; i <= 5; i++) {
                Loan loan = new Loan(0.10 + 0.01 * i, 10, 1000.0);
                output.writeObject(loan);
            }
        }
    }
}
