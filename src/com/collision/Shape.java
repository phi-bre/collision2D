package com.collision;

import java.util.ArrayList;

public abstract class Shape {

    protected float x, y, a;

    public abstract Vector[] getVectors();

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
}
