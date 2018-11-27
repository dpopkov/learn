package learn.hackerrank.java.d20181127.pqueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void tetGetComparatorByGpaNameId() {
        List<Student> list = Arrays.asList(
                new Student(2,"Bob", 3.3),
                new Student(1,"Bob", 3.4),
                new Student(4,"Bob", 3.2),
                new Student(5,"Bob", 3.2),
                new Student(3,"Ann", 3.2)
        );
        list.sort(Student.getComparatorByGpaNameId());
        assertThat(list.get(0).getID(), is(1));
        assertThat(list.get(1).getID(), is(2));
        assertThat(list.get(2).getID(), is(3));
        assertThat(list.get(3).getID(), is(4));
        assertThat(list.get(4).getID(), is(5));
    }
}
