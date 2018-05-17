package com.collision.line;

import com.collision.Point;

public class Segment extends Line {

    public Segment(Point a, Point b) {
        super(a, b);
    }

    public Segment(double ax, double ay, double bx, double by) {
        super(ax, ay, bx, by);
    }

    public double length() {
        double x = b.getX() - a.getX();
        double y = b.getY() - a.getX();
        return Math.sqrt(x * x + y * y);
    }
}
