package learn.ijpds.tools;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class AngleTest {
    private static final double E = 1e-13;
    public static final double PI6 = Math.PI / 6;

    @Test
    public void whenDx1Dy1Then45degrees() {
        double angle = Angle.get(0, 0, 1, 1);
        assertThat(angle, closeTo(45.0, E));
    }

    @Test
    public void whenDyFor30Then30degrees() {
        double angle = Angle.get(0, 0, 1, Math.tan(PI6));
        assertThat(angle, closeTo(30.0, E));
    }

    @Test
    public void whenDxDxFor30Then30degrees() {
        double angle = Angle.get(0, 0, Math.cos(PI6), Math.sin(PI6));
        assertThat(angle, closeTo(30.0, E));
    }

    @Test
    public void whenDxFor150Then150degrees() {
        double angle = Angle.get(0, 0, -Math.cos(PI6), Math.sin(PI6));
        assertThat(angle, closeTo(150.0, E));
    }

    @Test
    public void whenDxDxFor210Then210degrees() {
        double angle = Angle.get(0, 0, -Math.cos(PI6), -Math.sin(PI6));
        assertThat(angle, closeTo(210.0, E));
    }

    @Test
    public void whenDxDxFor330Then330degrees() {
        double angle = Angle.get(0, 0, Math.cos(PI6), -Math.sin(PI6));
        assertThat(angle, closeTo(330.0, E));
    }

    @Test
    public void whenMinus30Then330() {
        double result = Angle.convertToPositiveRange(-30);
        assertThat(result, closeTo(330, E));
    }

    @Test
    public void when390Then30() {
        double result = Angle.convertToPositiveRange(390);
        assertThat(result, closeTo(30, E));
    }
}
