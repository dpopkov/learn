package learn.dsai.ch02arrays.array4;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class PersonArrayTest {
    @Test
    public void testInsert() {
        PersonArray arr = new PersonArray(1);
        arr.insert("Dow", "John", 30);
        assertThat(arr.toString(), is("[Person{lastName='Dow', firstName='John', age=30}]"));
    }

    @Test
    public void whenFindNonExistingThenNull() {
        PersonArray arr = new PersonArray(1);
        arr.insert("Dow", "John", 30);
        Person person = arr.find("Sparrow");
        assertNull(person);
    }

    @Test
    public void whenFindExisting() {
        PersonArray arr = new PersonArray(1);
        arr.insert("Dow", "John", 30);
        Person person = arr.find("Dow");
        assertThat(person.getLastName(), is("Dow"));
    }

    @Test
    public void whenDeleteNonExistingThenFalse() {
        PersonArray arr = new PersonArray(1);
        arr.insert("Dow", "John", 30);
        boolean result = arr.delete("doW");
        assertFalse(result);
        assertThat(arr.toString(), is("[Person{lastName='Dow', firstName='John', age=30}]"));
    }

    @Test
    public void whenDeleteExistingThenTrue() {
        PersonArray arr = new PersonArray(1);
        arr.insert("Dow", "John", 30);
        boolean result = arr.delete("Dow");
        assertTrue(result);
        assertThat(arr.toString(), is("[]"));
    }

    @Test
    public void whenDeleteLastThenTrue() {
        PersonArray arr = new PersonArray(2);
        arr.insert("Dow", "John", 30);
        arr.insert("Black", "Amy", 31);
        boolean result = arr.delete("Black");
        assertTrue(result);
        assertThat(arr.toString(), is("[Person{lastName='Dow', firstName='John', age=30}]"));
    }
}
