package learn.ijpds2nd.ch06methods.exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E0618CheckPassword {
    public static void main(String[] args) {
        Checker atLeast10chars = password -> password.length() >= 10;
        Checker onlyLettersAndDigits = password -> {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (!(Character.isLetter(ch) || Character.isDigit(ch))) {
                    return false;
                }
            }
            return true;
        };
        Checker atLeast3Digits = password -> {
            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    count++;
                }
            }
            return count >= 3;
        };
        Checker checker = new UnionChecker(
                atLeast10chars,
                onlyLettersAndDigits,
                atLeast3Digits
        );
        Scanner in = new Scanner(System.in);
        System.out.print("Enter password: ");
        String s = in.next();
        boolean valid = checker.isValid(s);
        System.out.printf("Password %s is %s%n", s, valid ? "valid" : "not valid");
    }

    private interface Checker {
        boolean isValid(String password);
    }

    private static class UnionChecker implements Checker {
        private final List<Checker> checkers;

        public UnionChecker(Checker... arrayOfCheckers) {
            checkers = Arrays.asList(arrayOfCheckers);
        }

        @Override
        public boolean isValid(String password) {
            for (Checker c : checkers) {
                if (!c.isValid(password)) {
                    return false;
                }
            }
            return true;
        }
    }
}
