package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class E0821CentralCityTest {

    public static final double ERR = 1e-3;

    @Test
    public void testFindCentralCity() {
        double[] coordinates = {2.5, 5, 5.1, 3, 1, 9, 5.4, 54, 5.5, 2.1};
        double[] result = E0821CentralCity.findCentralCity(coordinates);
        double[] expected = {2.5, 5.0, 60.81};
        assertThat(result[0], closeTo(expected[0], ERR));
        assertThat(result[1], closeTo(expected[1], ERR));
        assertThat(result[2], closeTo(expected[2], ERR));
    }
}
