package collision;

import collision.line.Line;
import collision.line.Ray;

public class Reflection {

    private Vector vector;
    private Point origin;
    private Point destination;

    public Vector getVector() {
        return vector;
    }

    public Point getOrigin() {
        return origin;
    }

    public Point getDestination() {
        return destination;
    }

//    public static Reflection getReflection(Vector v1, Vector v2) {
//
//        double nx = -v1.y;
//        double ny = v1.x;
//        double dx = v2.x;
//        double dy = v2.y;
//
//        double l = (double) Math.sqrt(nx * nx + ny * ny);
//        double nxn = nx / l;
//        double nyn = ny / l;
//
//        double d = dx * nxn + dy * nyn;
//        double rx = dx - 2 * d * nxn;
//        double ry = dy - 2 * d * nyn;
//
//        return new Reflection(rx, ry);
//    }

    public static Reflection getReflection(Ray ray, Line line) {
//        Line l1 = intersection.getL1();
//        Line l2 = intersection.getL2();
//
//        Vector n = new Vector(intersection.x - l2.getB().x, intersection.y - l2.getB().y);
//        Vector d = new Vector(intersection.x - l1.getA().x, intersection.y - l1.getA().y);
//        Vector no = Vector.normalize(Vector.rotate(n, -90));
//        Vector r = Vector.subtract(d, Vector.multiplication(2 * Vector.dot(d, no), no));
//
//        Reflection reflection = new Reflection(r);
//        reflection.origin = intersection;
//
//        return reflection;


        Intersection intersection = Intersection.getIntersection(ray, line);
        if (intersection == null) throw new IllegalArgumentException("Ray and line do not intersect");

        double x = ray.getA().getX() - intersection.x;
        double y = ray.getA().getY() - intersection.y;
        double dx = line.getB().getX() - intersection.x;
        double dy = line.getB().getY() - intersection.y;

        Vector r = new Vector(x, y);
        Vector d = new Vector(dx, dy);

        r.rotate(r.getRotation() - d.getRotation());
        r.setX(-r.getX());
        r.rotate(r.getRotation() + d.getRotation());

        Reflection reflection = new Reflection();
        reflection.vector = r;
        reflection.origin = intersection;
        reflection.destination = new Point(r.x + intersection.x, r.y + intersection.y);

        return reflection;
    }

}
