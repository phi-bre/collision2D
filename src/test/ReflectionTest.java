import collision.Intersection;
import collision.Point;
import collision.Reflection;
import collision.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReflectionTest {

    @Test
    public void reflection() {
        Vector segment = new Vector(10, 20, 10, 0);
        Vector ray = new Vector(0, 0, 5, 5).setRay(true);

        Reflection reflection = Reflection.getReflection(ray, segment);
        Vector vector = reflection.getVector();
        Vector expected = new Vector(10, 10, 0, 20);

        assertEquals(expected.getX(), vector.getX(), 0.01);
        assertEquals(expected.getY(), vector.getY(), 0.01);
    }

}
