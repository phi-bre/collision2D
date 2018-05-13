package com.collision;

import com.collision.line.Line;
import com.collision.line.Ray;
import com.collision.line.Segment;

public class Intersection extends Point {

    private float t;
    private Line s1, s2;

    public Intersection(float x, float y, float t) {
        super(x, y);
        this.t = t;
    }

    /*
    public static Intersection getIntersection(Segment r, Segment s) {
        //Segment 1
        float v1px = s1.getA().getX();
        float v1py = s1.getA().getY();
        float v1dx = s1.getB().getX() - s1.getA().getX();
        float v1dy = s1.getB().getY() - s1.getA().getY();

        //Segment 2
        float v2px = s2.getA().getX();
        float v2py = s2.getA().getY();
        float v2dx = s2.getB().getX() - s2.getA().getX();
        float v2dy = s2.getB().getY() - s2.getA().getY();

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

        float x = v1px + v1dx * t1;
        float y = v1py + v1dy * t1;

        Intersection intersection = new Intersection(x, y, t1);
        intersection.s1 = s1;
        intersection.s2 = s2;
        return intersection;
    }
    */

    public static Intersection getIntersection(Line s1, Line s2) {

        // Line 1
        float v1px = s1.getA().getX();
        float v1py = s1.getA().getY();
        float v1dx = s1.getB().getX() - s1.getA().getX();
        float v1dy = s1.getB().getY() - s1.getA().getY();

        // Line 2
        float v2px = s2.getA().getX();
        float v2py = s2.getA().getY();
        float v2dx = s2.getB().getX() - s2.getA().getX();
        float v2dy = s2.getB().getY() - s2.getA().getY();

        // If Parallel
        float v1mag = (float) Math.sqrt(v1dx * v1dx + v1dy * v1dy);
        float v2mag = (float) Math.sqrt(v2dx * v2dx + v2dy * v2dy);
        if (v1dx / v1mag == v2dx / v2mag && v1dy / v1mag == v2dy / v2mag) { // Directions are the same.
            return null;
        }

        // Solve for T1 & T2
        float t2 = (v1dx * (v2py - v1py) + v1dy * (v1px - v2px)) / (v2dx * v1dy - v2dy * v1dx);
        float t1 = (v2px + v2dx * t2 - v1px) / v1dx;

        // Some magic
        if (t1 < 0) return null;
        if (!(s1 instanceof Ray) && t1 > 1) return null;
        if (t2 < 0 || t2 > 1) return null;

        float x = v1px + v1dx * t1;
        float y = v1py + v1dy * t1;

        Intersection intersection = new Intersection(x, y, t1);
        intersection.s1 = s1;
        intersection.s2 = s2;
        return intersection;

    }

//    public static Intersection getIntersection(Segment s1, Segment s2) {
//
//        Vector p = new Vector(s1.getA());
//        Vector s = Vector.subtract(new Vector(s1.getB()), p);
//        Vector q = new Vector(s2.getA());
//        Vector r = Vector.subtract(new Vector(s2.getB()), q);
//
//        float uN = Vector.cross(Vector.subtract(q, p), r);
//        float dE = Vector.cross(r, s);
//
//        if (uN == 0 && dE == 0) {
//            // Collinear
//
//        }
//
//        if (dE == 0) {
//            return null;
//        }
//
////        float t = Vector.dot(Vector.subtract(q, p), s) / (Vector.dot(r, s));
////        float u = Vector.dot(Vector.subtract(q, p), r) / Vector.dot(r, s);
//
//        float u = uN / dE;
//        float t = Vector.cross(Vector.subtract(q, p), s);
//
//        float x = p.getX() + s.getX() * t;
//        float y = p.getY() + s.getY() * t;
//
//        Intersection intersection = new Intersection(x, y, t);
//        intersection.s1 = s1;
//        intersection.s2 = s2;
//        return intersection;
//    }
}
