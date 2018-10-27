package learn.ijpds.ch17io.exercises;

import learn.ijpds.ch10oop.Loan;

import java.io.*;

public class E1707ReadSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "io/data/e_17_06.dat";
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            boolean hasData = true;
            while (hasData) {
                try {
                    Loan loan = (Loan) input.readObject();
                    System.out.println(loan.getTotalPayment());
                } catch (EOFException e) {
                    hasData = false;
                }
            }
        }
    }
}
