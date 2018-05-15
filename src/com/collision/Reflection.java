package com.collision;

import com.collision.line.Line;

public class Reflection {

    private Vector vector;

    public Reflection(float x, float y) {
        vector = new Vector(x, y);
    }

    public Reflection(Vector vector) {
        this.vector = vector;
    }

    public static Reflection getReflection(Vector v1, Vector v2) {

        float nx = -v1.y;
        float ny = v1.x;
        float dx = v2.x;
        float dy = v2.y;

        float l = (float) Math.sqrt(nx * nx + ny * ny);
        float nxn = nx / l;
        float nyn = ny / l;

        float d = dx * nxn + dy * nyn;
        float rx = dx - 2 * d * nxn;
        float ry = dy - 2 * d * nyn;

        return new Reflection(rx, ry);
    }

    public static Reflection getReflection(Intersection intersection) {
        Line l1 = intersection.getL1();
        Line l2 = intersection.getL2();

        Vector v1 = new Vector(intersection.x - l2.getB().x, intersection.y - l2.getB().y);
        Vector v2 = new Vector(intersection.x - l1.getA().x, intersection.y - l1.getA().y);

        return getReflection(v1, v2);
    }
}
