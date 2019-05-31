package learn.dsajg6e.ch01primer.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Takes all the lines input to standard input and writes them
 * to standard output in reverse order.
 */
public class P0126RevLines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> stack = new ArrayDeque<>();
        String line;
        while (!(line = br.readLine()).equals("exit")) {
            stack.push(line);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
