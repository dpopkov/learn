package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.CaesarCipher;

import java.util.Scanner;

public class R0303RegionalCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher(5, CaesarCipher.Alphabet.RUSSIAN);
        System.out.print("Enter message: ");
        String msg = in.nextLine();
        String secret = cipher.encrypt(msg);
        System.out.println("Encrypted:");
        System.out.println(secret);
        System.out.println("Decrypted:");
        System.out.println(cipher.decrypt(secret));
    }
}
