package classes;

import collision.Intersection;
import collision.Point;
import collision.line.Ray;
import collision.line.Segment;
import collision.shape.Polygon;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntersectionTest {

    @Test
    public void intersection() {
        Segment segment = new Segment(1, 1, 4, 3);
        Ray ray = new Ray(1, 4, 4, 1);

        Intersection intersection = Intersection.getIntersection(segment, ray);
        assertEquals(new Point(0, 0), intersection);

    }

}
