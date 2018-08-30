package learn.core1.ch04;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class EmployeeTest {
    @Before
    public void setUpEmployee() {
        Employee.resetNextId();
    }

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
}
