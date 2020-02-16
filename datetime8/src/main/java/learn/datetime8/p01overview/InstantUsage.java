package learn.datetime8.p01overview;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class InstantUsage {
    public static void main(String[] args) {
        System.out.println("Midnight of January 1st 1970:");
        Instant e = Instant.EPOCH;
        System.out.println("EPOCH = " + e);
        System.out.println("Instant using EPOCH seconds");
        Instant i2 = Instant.ofEpochSecond(120);
        System.out.println("i2 = " + i2);

        System.out.println("Using Duration:");
        Duration d = Duration.between(e, i2);
        System.out.println("d = " + d);

        System.out.println("Adding Duration to Instant:");
        Instant i3 = i2.plus(d);
        System.out.println("i3 = " + i3);

        System.out.println("Creating Date from Instant:");
        Date date = Date.from(i3);
        System.out.println("date = " + date);

        System.out.println("Converting Date to Instant:");
        Instant i4 = date.toInstant();
        System.out.println("i4 = " + i4);
    }
}
