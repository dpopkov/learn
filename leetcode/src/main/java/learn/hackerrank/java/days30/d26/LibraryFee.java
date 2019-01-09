package learn.hackerrank.java.days30.d26;

import java.util.*;

public class LibraryFee {
    public static void main(String[] args) {
        Solution.main(args);
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dayA = in.nextInt();
        int monthA = in.nextInt();
        int yearA = in.nextInt();
        in.nextLine();
        int dayD = in.nextInt();
        int monthD = in.nextInt();
        int yearD = in.nextInt();
        int fine = 0;
        if (yearA > yearD) {
            fine = 10_000;
        } else if (yearA == yearD) {
            if (monthA > monthD) {
                fine = 500 * (monthA - monthD);
            } else if (monthA == monthD && dayA > dayD) {
                fine = 15 * (dayA - dayD);
            }
        }
        System.out.println(fine);
    }
}