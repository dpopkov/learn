package learn.ijpds2nd.ch03select;

/* Listing 3.9 */

import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = in.nextInt();

        String chinese;
        switch (year % 12) {    // this switch statement is used on purpose as example
            case 0: chinese = "monkey"; break;
            case 1: chinese = "rooster"; break;
            case 2: chinese = "dog"; break;
            case 3: chinese = "pig"; break;
            case 4: chinese = "rat"; break;
            case 5: chinese = "ox"; break;
            case 6: chinese = "tiger"; break;
            case 7: chinese = "rabbit"; break;
            case 8: chinese = "dragon"; break;
            case 9: chinese = "snake"; break;
            case 10: chinese = "horse"; break;
            case 11: chinese = "sheep"; break;
            default: chinese = "invalid value"; break;
        }
        System.out.println(chinese);
    }
}
