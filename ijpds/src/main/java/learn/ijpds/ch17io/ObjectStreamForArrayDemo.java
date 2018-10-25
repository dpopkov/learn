/* 17.7 */
package learn.ijpds.ch17io;
import java.io.*;

public class ObjectStreamForArrayDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"John", "Susan", "Kim", "Ann"};
        String path = "io/data/array.dat";
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
            output.writeObject(numbers);
            output.writeObject(strings);
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            int[] newNumbers = (int[]) input.readObject();
            String[] newStrings = (String[]) input.readObject();
            for (int n : newNumbers) {
                System.out.print(n + " ");
            }
            System.out.println();
            for (String s : newStrings) {
                System.out.print(s + " ");
            }
        }
    }
}
