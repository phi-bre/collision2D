package collision;

import collision.line.Line;
import collision.line.Ray;

public class Intersection extends Point {

    private double t1, t2;
    private Line l1, l2;

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

    public Line getL1() {
        return l1;
    }

    public Line getL2() {
        return l2;
    }

    public static Intersection getIntersection(Line l1, Line l2) {

        //long past = System.currentTimeMillis();
        // Line 1
        double v1px = l1.getA().getX();
        double v1py = l1.getA().getY();
        double v1dx = l1.getB().getX() - l1.getA().getX();
        double v1dy = l1.getB().getY() - l1.getA().getY();

        // Line 2
        double v2px = l2.getA().getX();
        double v2py = l2.getA().getY();
        double v2dx = l2.getB().getX() - l2.getA().getX();
        double v2dy = l2.getB().getY() - l2.getA().getY();

        // If Parallel
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
        if (!(l1 instanceof Ray) && t1 > 1) return null;
        if (t2 < 0 || t2 > 1) return null;

        double x = v1px + v1dx * t1;
        double y = v1py + v1dy * t1;

        //System.out.println(System.currentTimeMillis() - past);

        Intersection intersection = new Intersection(x, y, t1, t2);
        intersection.l1 = l1;
        intersection.l2 = l2;
        return intersection;
    }

}
