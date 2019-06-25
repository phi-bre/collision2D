package collision;

public class Intersection extends Point {

    private double t1, t2;
    private Vector v1, v2;

    public Intersection(double x, double y, double t1, double t2) {
        super(x, y);
        this.t1 = t1;
        this.t2 = t2;
    }

    public double getT1() {
        return t1;
    }

    public double getT2() {
        return t2;
    }

    public Vector getV1() {
        return v1;
    }

    public Vector getV2() {
        return v2;
    }

    public static Intersection getIntersection(Vector v1, Vector v2) {

        // Line 1
        double v1px = v1.getOrigin().getX();
        double v1py = v1.getOrigin().getY();
        double v1dx = v1.getX() - v1px;
        double v1dy = v1.getY() - v1py;

        // Line 2
        double v2px = v2.getOrigin().getX();
        double v2py = v2.getOrigin().getY();
        double v2dx = v2.getX() - v2px;
        double v2dy = v2.getY() - v2py;

        // If parallel
        double v1mag = Math.sqrt(v1dx * v1dx + v1dy * v1dy);
        double v2mag = Math.sqrt(v2dx * v2dx + v2dy * v2dy);
        if (v1dx / v1mag == v2dx / v2mag && v1dy / v1mag == v2dy / v2mag) { // Directions are the same.
            return null;
        }

        // Solve for T1 & T2
        double t2 = (v1dx * (v2py - v1py) + v1dy * (v1px - v2px)) / (v2dx * v1dy - v2dy * v1dx);
        double t1 = (v2px + v2dx * t2 - v1px) / v1dx;

        // Some magic
        if (t1 < 0) return null;
        if (!(v1.isNormalized()) && t1 > 1) return null;
        if (t2 < 0 || t2 > 1) return null;

        double x = v1px + v1dx * t1;
        double y = v1py + v1dy * t1;

        Intersection intersection = new Intersection(x, y, t1, t2);
        intersection.v1 = v1;
        intersection.v2 = v2;
        return intersection;
    }

}
