package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0807NearestPointsTest {

    @Test
    public void testFindNearestPoints() {
        Point[] points = {
                Point.of(-1, 0, 3),
                Point.of(-1, -1, -1),
                Point.of(4, 1, 1),
                Point.of(2, 0.5, 9),
                Point.of(3.5, 2, -1),
                Point.of(3, 1.5, 3),
                Point.of(-1.5, 4, 2),
                Point.of(5.5, 4, -0.5)
        };
        Pair<Point> result = E0807NearestPoints.findNearestPoints(points);
        Pair<Point> expected = new Pair<>(Point.of(4, 1, 1), Point.of(3.5, 2, -1));
        assertThat(result, is(expected));
    }
}
