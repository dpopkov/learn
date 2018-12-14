package learn.dsai.ch11ht.doubleh;

import learn.dsai.ch11ht.HashTableApplication;

import java.util.Scanner;

public class HashDoubleApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter initial number of items: ");
        int n = in.nextInt();
        in.skip("\\s");
        HashTableApplication app = new HashTableApplication(new HashTable(), n);
        app.run(in);
    }
}
