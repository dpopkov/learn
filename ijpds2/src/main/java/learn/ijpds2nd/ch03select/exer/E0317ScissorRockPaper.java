package learn.ijpds2nd.ch03select.exer;

import java.util.Random;
import java.util.Scanner;

public class E0317ScissorRockPaper {

    private enum Entity {
        SCISSOR,
        ROCK,
        PAPER;

        public static int compare(Entity e1, Entity e2) {
            if (e1 == e2) {
                return 0;
            } else if (e1 == SCISSOR && e2 == ROCK || e1 == ROCK && e2 == PAPER || e1 == PAPER && e2 == SCISSOR) {
                return -1;
            } else if (e1 == SCISSOR && e2 == PAPER || e1 == ROCK && e2 == SCISSOR || e1 == PAPER && e2 == ROCK) {
                return 1;
            }
            throw new IllegalArgumentException("Can not compare these entities: " + e1 + ", " + e2);
        }

        public static Entity byNumber(int i) {
            return Entity.values()[i];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter -1 to exit.");
        while (true) {
            Entity compEntity = Entity.byNumber(random.nextInt(3));
            System.out.print("scissor (0), rock (1), paper (2): ");
            int guess = in.nextInt();
            if (guess == -1) {
                break;
            } else if (guess >= Entity.values().length) {
                System.out.println("Invalid number of entity. Try again.");
                continue;
            }
            Entity guessEntity = Entity.byNumber(guess);
            String result = calcResult(compEntity, guessEntity);
            System.out.printf("The computer is %s. You are %s. %s.%n",
                    compEntity, guessEntity, "draw".equals(result) ? "It is a draw" : "You " + result);
        }
    }

    private static String calcResult(Entity comp, Entity you) {
        int cmp = Entity.compare(comp, you);
        if (cmp == 0) {
            return "draw";
        } else if (cmp < 0) {
            return "won";
        } else {
            return "lost";
        }
    }
}
