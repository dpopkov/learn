package learn.csia.ch0102.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E010235DragonCurvesTest {
    @Test
    public void whenOrder0ThenF() {
        String result = E010235DragonCurves.buildDragonCurves(0);
        assertThat(result, is("F"));
    }

    @Test
    public void whenOrder1ThenFLF() {
        String result = E010235DragonCurves.buildDragonCurves(1);
        assertThat(result, is("FLF"));
    }

    @Test
    public void whenOrder2ThenFLFLFRF() {
        String result = E010235DragonCurves.buildDragonCurves(2);
        assertThat(result, is("FLFLFRF"));
    }

    @Test
    public void whenOrder3ThenFLFLFRFLFLFRFRF() {
        String result = E010235DragonCurves.buildDragonCurves(3);
        assertThat(result, is("FLFLFRFLFLFRFRF"));
    }
}
