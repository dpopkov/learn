package learn.dsai.ch11ht.linear;

import learn.dsai.ch11ht.HashTableApplication;

import java.util.Scanner;

public class HashTableApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter capacity of hash table: ");
        int capacity = in.nextInt();
        System.out.print("Enter initial number of items: ");
        int n = in.nextInt();
        in.skip("\\s");
        HashTable table = new HashTable(capacity);
        HashTableApplication app = new HashTableApplication(table, n);
        app.run(in);
    }
}
