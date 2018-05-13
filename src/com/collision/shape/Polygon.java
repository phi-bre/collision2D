package com.collision.shape;

import com.collision.Intersection;
import com.collision.Point;
import com.collision.Vector;
import com.collision.line.Segment;

import java.util.ArrayList;

public class Polygon extends Shape {

    protected Vector[] vectors;
    protected Point[] points;
    protected Segment[] segments;

    public Polygon(float x, float y, float a, Vector ... vectors) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.vectors = vectors;
        update();

        segments = new Segment[vectors.length];
        for (int i = 0; i < segments.length; i++) {
            if (i == segments.length - 1) {
                segments[i] = new Segment(points[i], points[0]);
            } else {
                segments[i] = new Segment(points[i], points[i+1]);
            }
        }
    }

    @Override
    public void update() {
        boolean initialize = (points == null);
        if (initialize) points = new Point[vectors.length];

        // Calculate Points
        for (int i = 0; i < vectors.length; i++) {
            Vector vector = vectors[i];
            float x = vector.getX() + this.x;
            float y = vector.getY() + this.y;

            if (initialize) {
                points[i] = new Point(x, y);
            } else {
                points[i].setPosition(x, y);
            }
        }
    }

    @Override
    public Intersection[] getIntersections(Shape shape) {
        ArrayList<Intersection> intersections = new ArrayList<>();

        if (shape instanceof Polygon) {
            for (Segment segment : segments) {
                for (Segment s : ((Polygon) shape).segments) {
                    Intersection i = Intersection.getIntersection(segment, s);
                    if (i != null) intersections.add(i);
                }
            }
        }

        return intersections.toArray(new Intersection[0]);
    }

    @Override
    public void translate(float x, float y) {
        for (Vector vector : vectors) {
            vector.translate(x, y);
        }
        update();
    }

    @Override
    public void rotate(float a) {
        for (Vector vector : vectors) {
            vector.rotate(a);
        }
        update();
    }

    public Vector[] getVectors() {
        return vectors;
    }

    public Point[] getPoints() {
        return points;
    }

    public Segment[] getSegments() {
        return segments;
    }

}
