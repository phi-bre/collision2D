import collision.Intersection;
import collision.Point;

import static org.junit.Assert.assertEquals;

import collision.Vector;
import org.junit.Test;

public class IntersectionTest {

    @Test
    public void intersection() {
        Vector segment = new Vector(1, 1, 4, 3);
        Vector ray = new Vector(1, 4, 4, 1).normalize();

        Intersection intersection = Intersection.getIntersection(segment, ray);
        assertEquals(new Point(0, 0), intersection);

    }

}
