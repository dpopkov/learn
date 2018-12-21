package learn.dsai.ch08trees.projects;

import java.util.Scanner;
import java.util.function.Function;

public class LettersTreeApp {
    private final Function<String, AbstractLettersTree> constructor;

    public LettersTreeApp(Function<String, AbstractLettersTree> constructor) {
        this.constructor = constructor;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = in.nextLine();
        AbstractLettersTree tree = constructor.apply(s);
        System.out.println("Tree as string: " + tree);
        System.out.println(tree.buildForDisplay());
    }
}
