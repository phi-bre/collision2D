package com.collision;

import com.collision.line.Line;

public class Reflection {

    private Vector vector;

    public Reflection(double x, double y) {
        vector = new Vector(x, y);
    }

    public Reflection(Vector vector) {
        this.vector = vector;
    }

    public static Reflection getReflection(Vector v1, Vector v2) {

        double nx = -v1.y;
        double ny = v1.x;
        double dx = v2.x;
        double dy = v2.y;

        double l = (double) Math.sqrt(nx * nx + ny * ny);
        double nxn = nx / l;
        double nyn = ny / l;

        double d = dx * nxn + dy * nyn;
        double rx = dx - 2 * d * nxn;
        double ry = dy - 2 * d * nyn;

        return new Reflection(rx, ry);
    }

    public static Reflection getReflection(Intersection intersection) {
        Line l1 = intersection.getL1();
        Line l2 = intersection.getL2();

        Vector v1 = new Vector(intersection.x - l2.getB().x, intersection.y - l2.getB().y);
        Vector v2 = new Vector(intersection.x - l1.getA().x, intersection.y - l1.getA().y);

        return getReflection(v1, v2);
    }

    public static void main(String[] args) {
        Vector v1 = new Vector(0, 3);
        Vector v2 = new Vector(-3, 3);
        Reflection r = getReflection(v2, v1);

        System.out.println(r.vector.getX() + ", " + r.vector.getY());
    }
}
