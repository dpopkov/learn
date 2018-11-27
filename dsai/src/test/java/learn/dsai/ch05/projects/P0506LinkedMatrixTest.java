package learn.dsai.ch05.projects;

import org.junit.Test;

import java.util.StringJoiner;
import java.util.function.Supplier;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0506LinkedMatrixTest {

    @Test
    public void whenNoDataThenContainsNulls() {
        P0506LinkedMatrix<String> matrix = new P0506LinkedMatrix<>(2, 2);
        String expected = new StringJoiner(System.lineSeparator())
                .add("null null")
                .add("null null").toString();
        assertThat(matrix.toString(), is(expected));
    }

    @Test
    public void whenDataSupplierThenDataIsStored() {
        Supplier<String> testDataSupplier = new Supplier<String>() {
            private int count = 0;
            @Override
            public String get() {
                return Integer.toString(++count);
            }
        };
        P0506LinkedMatrix<String> matrix = new P0506LinkedMatrix<>(2, 2, testDataSupplier);
        String expected = new StringJoiner(System.lineSeparator())
                .add("3 4")
                .add("1 2").toString();
        assertThat(matrix.toString(), is(expected));
    }

    @Test
    public void testInsert() {
        P0506LinkedMatrix<String> matrix = new P0506LinkedMatrix<>(2, 2);
        matrix.insert("00", 0, 0);
        matrix.insert("01", 0, 1);
        matrix.insert("10", 1, 0);
        matrix.insert("11", 1, 1);
        String expected = new StringJoiner(System.lineSeparator())
                .add("00 01")
                .add("10 11").toString();
        assertThat(matrix.toString(), is(expected));
    }
}
