package com.collision;

import java.util.ArrayList;

public abstract class Shape {

    protected float x, y, a;
    protected Point[] points;
    protected Vector[] vectors;

    public Vector[] getVectors() {
        return vectors;
    }

    public Point[] getPoints() {
        return points;
    }

    public static Intersection[] getIntersections(Shape s1, Shape s2) {
        ArrayList<Intersection> intersections = new ArrayList<>();
//        if (s1 instanceof Circle) {
//            if (s2 instanceof Circle) {
//
//            } else {
//                for (Vector v : s2.getVectors()) {
//                    Intersection i = Intersection.getIntersection(vector, v);
//                    if (i != null)
//                        intersections.add(i);
//                }
//            }
//        } else {
//            for (Vector vector : s1.getVectors()) {
//                for (Vector v : s2.getVectors()) {
//                    Intersection i = Intersection.getIntersection(vector, v);
//                    if (i != null)
//                        intersections.add(i);
//                }
//            }
//        }
        for (Vector vector : s1.getVectors()) {
            for (Vector v : s2.getVectors()) {
                Intersection i = Intersection.getIntersection(vector, v);
                if (i != null)
                    intersections.add(i);
            }
        }

        return intersections.toArray(new Intersection[0]);
    }

    public Intersection[] getIntersections(Shape shape) {
        return Shape.getIntersections(this, shape);
    }

    public abstract void setPosition(float x, float y);
    public abstract void setAngle(float a);
    public abstract void setX(float x);
    public abstract void setY(float y);

}
