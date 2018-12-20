package learn.dsai.ch08trees.projects;

import java.util.Scanner;

public class P0801LettersTreeApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = in.nextLine();
        P0801LettersTree tree = new P0801LettersTree(s);
        System.out.println("Tree as string: " + tree);
        System.out.println(tree.buildForDisplay());
    }
}
