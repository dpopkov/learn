package learn.hackerrank.java.d20181127.pqueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class PrioritiesTest {

    @Test
    public void whenEmptyInputThenEmptyOutput() {
        Priorities priorities = new Priorities();
        List<Student> result = priorities.getStudents(Collections.emptyList());
        assertThat(result.size(), is(0));
    }

    @Test
    public void whenEnterStudentThenReturnsStudent() {
        String enter = "ENTER Jack 4.5 42";
        Priorities priorities = new Priorities();
        List<Student> result = priorities.getStudents(Arrays.asList(enter));
        assertThat(result.size(), is(1));
        Student student = result.get(0);
        assertThat(student.getCGPA(), is(4.5));
        assertThat(student.getID(), is(42));
        assertThat(student.getName(), is("Jack"));
    }

    @Test
    public void whenEnterAndServeAllStudentsThenResultIsEmpty() {
        String enter1 = "ENTER Jack 4.4 41";
        String enter2 = "ENTER Jacky 4.3 42";
        Priorities priorities = new Priorities();
        List<Student> result = priorities.getStudents(Arrays.asList(enter1, enter2, "SERVED", "SERVED"));
        assertThat(result.size(), is(0));
    }

    @Test
    public void whenEnterAndServeStudentsThenServeByPriority() {
        String enter1 = "ENTER Jack 4.4 41";
        String enter2 = "ENTER Jacky 4.3 42";
        Priorities priorities = new Priorities();
        List<Student> result = priorities.getStudents(Arrays.asList(enter1, enter2, "SERVED"));
        assertThat(result.size(), is(1));
        Student student = result.get(0);
        assertThat(student.getCGPA(), is(4.3));
        assertThat(student.getID(), is(42));
        assertThat(student.getName(), is("Jacky"));
    }
}
