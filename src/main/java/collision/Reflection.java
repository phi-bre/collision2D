package collision;

public class Reflection { // TODO: Extend Vector

    private Vector vector;
    private Point origin;

    public Vector getVector() {
        return vector;
    }

    public Point getOrigin() {
        return origin;
    }

    public static Reflection getReflection(Vector ray, Vector line) {

        // TODO: if n collinear return inverse

        Intersection intersection = Intersection.getIntersection(ray, line);
        if (intersection == null) throw new IllegalArgumentException("Ray and line do not intersect");

        System.out.println(intersection.x + ", " + intersection.y);

        double dx = intersection.x - ray.getOrigin().getX();
        double dy = intersection.y - ray.getOrigin().getY();
        double nx = line.y - line.getOrigin().getY();
        double ny = -(line.x - line.getOrigin().getX());

        // calculate reflection
        double numerator = 2 * (dx * nx + dy * ny);
        double denominator = nx * nx + ny * ny;
        double scalar = -(numerator / denominator);
        double tnx = scalar * nx;
        double tny = scalar * ny;
        double tdx = dx + dx + tnx;
        double tdy = dy + dy + tny;

        Vector v = new Vector(intersection.x, intersection.y, tdx, tdy);

        Reflection reflection = new Reflection();
        reflection.vector = v;
        reflection.origin = intersection;

        return reflection;
    }

}
