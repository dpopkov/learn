package learn.core1.ch08generics.erasure;

import learn.core1.ch08generics.Pair;

import java.time.LocalDate;

/*
    Compiler will generate bridge methods for this class.
    Horstmann, v.1, 8.5
 */
public class DateInterval extends Pair<LocalDate> {
    @Override
    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }

    public static void main(String[] args) {
        LocalDate first = LocalDate.of(2017, 1, 1);
        LocalDate second = LocalDate.of(2017, 1, 2);
        LocalDate second2 = LocalDate.of(2017, 1, 3);
        DateInterval interval = new DateInterval();
        interval.setFirst(first);
        interval.setSecond(second);

        Pair<LocalDate> pair = interval;
        pair.setSecond(second2);
        System.out.println(pair);
    }
}
