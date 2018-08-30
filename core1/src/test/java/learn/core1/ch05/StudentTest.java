package learn.core1.ch05;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void whenNameAndMajorThenConstructs() {
        Student student = new Student("Name1", "CS101");
        assertThat(student.getName(), is("Name1"));
    }

    @Test
    public void whenMajorThenDescriptionCorresponds() {
        Student student = new Student("Name1", "CS101");
        assertThat(student.getDescription(), is("a student majoring in CS101"));
    }
}
