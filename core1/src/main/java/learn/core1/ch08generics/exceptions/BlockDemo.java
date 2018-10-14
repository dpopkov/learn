package learn.core1.ch08generics.exceptions;

import java.io.File;
import java.util.Scanner;

public class BlockDemo {
    public static void main(String[] args) {
        new Block() {
            @Override
            public void body() throws Exception {
                Scanner in = new Scanner(new File("not-existing-file"));
                while (in.hasNext()) {
                    System.out.println(in.next());
                }
            }
        }.toThread().start();
    }
}
