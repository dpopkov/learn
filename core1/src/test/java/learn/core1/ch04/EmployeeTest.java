package learn.core1.ch04;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Before
    public void setUpEmployee() {
        Employee.resetNextId();
    }

    /* Test Constructors */
    @Test
    public void whenNameAndSalaryThenConstructs() {
        Employee employee = new Employee("Name1", 100_000);
        assertThat(employee.getId(), is(1));
        assertThat(employee.getName(), is("Name1"));
        assertThat(employee.getSalary(), closeTo(100_000, 0.1));
    }

    @Test
    public void whenMoreThanOneThenConsecutiveIds() {
        Employee e1 = new Employee("name1", 10);
        Employee e2 = new Employee("name2", 10);
        assertThat(e1.getId(), is(1));
        assertThat(e2.getId(), is(2));
    }

    @Test
    public void whenSalaryThenConstructsWithDefaultName() {
        Employee employee = new Employee(100_000);
        assertThat(employee.getId(), is(1));
        assertThat(employee.getName(), is("Employee #1"));
        assertThat(employee.getSalary(), closeTo(100_000, 0.1));
    }

    @Test
    public void whenNameSalaryHireDateThenConstructs() {
        Employee e = new Employee("Name1", 100_000, 2000, 5, 17);
        assertThat(e.getId(), is(1));
        assertThat(e.getName(), is("Name1"));
        assertThat(e.getSalary(), closeTo(100_000, 0.1));
        assertThat(e.getHireDay(), is(LocalDate.of(2000, 5, 17)));
    }

    /* Test getDescription */
    @Test
    public void whenSalary100ThenDescriptionCorresponds() {
        Employee e = new Employee("Name1", 100);
        assertThat(e.getDescription(), is("an employee with a salary of $100.00"));
    }

    /* Test equals() and hashCode */
    @Test
    public void whenHaveSameNameSalaryHireDateThenEqual() {
        Employee e1 = new Employee("Name1", 100, 2000, 1, 2);
        Employee e2 = new Employee("Name1", 100, 2000, 1, 2);
        assertEquals(e1, e2);
    }

    @Test
    public void whenHaveDifferentFieldsThenNotEqual() {
        Employee e1 = new Employee("Name1", 100, 2000, 1, 2);
        Employee e2 = new Employee("Name2", 100, 2000, 1, 2);
        Employee e3 = new Employee("Name1", 101, 2000, 1, 2);
        Employee e4 = new Employee("Name1", 100, 2000, 1, 3);
        assertNotEquals(e1, e2);
        assertNotEquals(e1, e3);
        assertNotEquals(e1, e4);
    }

    @Test
    public void whenEqualThenSameHashcode() {
        Employee e1 = new Employee("Name1", 100, 2000, 1, 2);
        Employee e2 = new Employee("Name1", 100, 2000, 1, 2);
        assertNotSame(e1, e2);
        assertThat(e1.hashCode(), is(e2.hashCode()));
    }
}
