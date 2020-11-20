import collision.Intersection;
import collision.Point;

import static org.junit.Assert.assertEquals;

import collision.Vector;
import org.junit.Test;

public class IntersectionTest {

    @Test
    public void intersection() {
        Vector segment = new Vector(0, 0, 100, 100);
        Vector ray = new Vector(0, 100, 100, -100).normalize();

        Intersection intersection = Intersection.getIntersection(segment, ray);
        System.out.println(intersection.getX());
        //assertEquals(new Point(0, 0), intersection);
    }

}
