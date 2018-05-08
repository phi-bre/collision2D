package com.collision;

public class Intersection extends Point {

    private float t;

    public Intersection(float x, float y, float t) {
        super(x, y);
        this.t = t;
    }

    public static Intersection getIntersection(Vector v1, Vector v2) {

        //Vector 1
        float v1px = v1.getA().getX();
        float v1py = v1.getA().getY();
        float v1dx = v1.getB().getX() - v1.getA().getX();
        float v1dy = v1.getB().getY() - v1.getA().getY();

        //Vector 2
        float v2px = v2.getA().getX();
        float v2py = v2.getA().getY();
        float v2dx = v2.getB().getX() - v2.getA().getX();
        float v2dy = v2.getB().getY() - v2.getA().getY();

        //If Parallel
        float v1mag = (float) Math.sqrt(v1dx * v1dx + v1dy * v1dy);
        float v2mag = (float) Math.sqrt(v2dx * v2dx + v2dy * v2dy);
        if (v1dx / v1mag == v2dx / v2mag && v1dy / v1mag == v2dy / v2mag) { // Directions are the same.
            return null;
        }

        //Solve for T1 & T2
        float t2 = (v1dx * (v2py - v1py) + v1dy * (v1px - v2px)) / (v2dx * v1dy - v2dy * v1dx);
        float t1 = (v2px + v2dx * t2 - v1px) / v1dx;

        //Some magic
        if (t1 < 0) return null;
        if (t2 < 0 || t2 > 1) return null;

        return new Intersection(v1px + v1dx * t1, v1py + v1dy * t1, t1);
    }

    public static void main(String[] args) {
        Vector v1 = new Vector(-10, 0, 10, 0);
        Vector v2 = new Vector(0, 10, 4, -9);

        Intersection i = Intersection.getIntersection(v1, v2);
        System.out.println(i.t);
    }
}
