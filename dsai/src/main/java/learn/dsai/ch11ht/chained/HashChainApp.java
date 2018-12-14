package learn.dsai.ch11ht.chained;

import learn.dsai.ch11ht.HashTableApplication;

import java.util.Scanner;

public class HashChainApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of hashtable: ");
        int tableSize = in.nextInt();
        System.out.print("Enter initial number of items: ");
        int n = in.nextInt();
        in.skip("\\s");
        HashTableApplication app = new HashTableApplication(new HashTable(tableSize), n);
        app.run(in);
    }
}
