package learn.ijpds2nd.ch03select.exer;

import java.util.Random;

public class E0304RandomMonth {
    public static void main(String[] args) {
        Random random = new Random();
        int month = random.nextInt(12);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        System.out.println(months[month]);
    }
}
