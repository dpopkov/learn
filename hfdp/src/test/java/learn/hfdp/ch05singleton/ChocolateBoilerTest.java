package learn.hfdp.ch05singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChocolateBoilerTest {

    @Test
    public void fill() {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        boiler.fill();
        assertThat(boiler.isEmpty(), is(false));
    }

    @Test
    public void drain() {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        boiler.fill();
        assertThat(boiler.isEmpty(), is(false));
        boiler.boil();
        boiler.drain();
        assertThat(boiler.isEmpty(), is(true));
    }

    @Test
    public void boil() {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        boiler.fill();
        boiler.boil();
        assertThat(boiler.isBoiled(), is(true));
    }
}
