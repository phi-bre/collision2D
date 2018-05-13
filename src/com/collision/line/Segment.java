package com.collision.line;

import com.collision.Point;

public class Segment extends Line {

    public Segment(Point a, Point b) {
        super(a, b);
    }

    public Segment(float ax, float ay, float bx, float by) {
        super(ax, ay, bx, by);
    }

    public float length() {
        float x = b.getX() - a.getX();
        float y = b.getY() - a.getX();
        return (float) Math.sqrt(x * x + y * y);
    }
}
