package learn.dsai.helpers.combinations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationGeneratorApp {
    private final CombinationGenerator generator;

    public CombinationGeneratorApp(CombinationGenerator generator) {
        this.generator = generator;
    }

    public void run(int n, int r) {
        List<int[]> selection = generator.generate(n, r);
        selection.forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n and r: ");
        int n = in.nextInt();
        int r = in.nextInt();
        CombinationGeneratorApp app = new CombinationGeneratorApp(new IterativeCombinationGenerator());
        app.run(n, r);
    }
}
