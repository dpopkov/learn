package learn.ijpds.ch20collections.exercises.e2003capitals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FormatStates {

    public static void main(String[] args) {
        String name = "io/text/states.txt";
        File file = new File(name);
        List<String> prefixes = Arrays.asList("New", "North", "Rhode", "South", "West");
        List<State> states = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("\\s");
                State state = new State();
                boolean haveTitle = false;
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].isEmpty()) {
                        continue;
                    }
                    if ( !haveTitle) {
                        if (prefixes.indexOf(tokens[i]) > -1) {
                            state.setTitle(join(tokens, i, i + 2));
                            i++;
                        } else {
                            state.setTitle(tokens[i]);
                        }
                        haveTitle = true;
                    } else {
                        state.setCapital(join(tokens, i, tokens.length));
                        break;
                    }
                }
                states.add(state);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (FileWriter writer = new FileWriter("io/text/capitals.csv")) {
            for (State st : states) {
                writer.append(String.format("%s,%s%n", st.getTitle(), st.getCapital()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String join(String[] words, int from, int to) {
        StringJoiner joiner = new StringJoiner(" ", "", "");
        for (int i = from; i < to; i++) {
            joiner.add(words[i]);
        }
        return joiner.toString();
    }
}
