package learn.core1.ch09collections2;

import java.util.EnumSet;

public class EnumSetDemo {
    @SuppressWarnings("unused")
    enum WeekDay { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static void main(String[] args) {
        EnumSet<WeekDay> always = EnumSet.allOf(WeekDay.class);
        System.out.println("always = " + always);
        EnumSet<WeekDay> never = EnumSet.noneOf(WeekDay.class);
        System.out.println("never = " + never);
        EnumSet<WeekDay> workDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println("workDays = " + workDays);
        EnumSet<WeekDay> mwf = EnumSet.of(WeekDay.MONDAY, WeekDay.WEDNESDAY, WeekDay.FRIDAY);
        System.out.println("mwf = " + mwf);
    }
}



