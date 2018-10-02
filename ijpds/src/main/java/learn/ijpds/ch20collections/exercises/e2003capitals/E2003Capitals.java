/*
20.3
Write a program that repeatedly prompts the user to enter a capital for a state.
 */
package learn.ijpds.ch20collections.exercises.e2003capitals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E2003Capitals {
    public static void main(String[] args) {
        String fileName = "io/text/capitals.csv";
        List<State> states = readStates(fileName);
        Collections.shuffle(states);
        Scanner in = new Scanner(System.in);
        int i = 0;
        String answer;
        do {
            State state = states.get(i);
            System.out.printf("What is the capital of '%s'? ", state.getTitle());
            answer = in.nextLine();
            if (answer.equals(state.getCapital())) {
                System.out.println("That's correct!");
            } else {
                System.out.printf("No, the capital is '%s'.%n", state.getCapital());
            }
            i++;
            System.out.print("Continue? (y/n): ");
            answer = in.nextLine();
        } while (answer.equals("y"));
    }

    private static List<State> readStates(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist: " + fileName);
        }
        List<State> states = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String csv = scanner.nextLine();
                states.add(State.parseCsv(csv));
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return states;
    }
}
