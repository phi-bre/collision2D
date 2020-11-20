package com.collision.line;

import com.collision.Point;

public class Ray extends Line {

    public Ray(Point a, Point b) {
        super(a, b);
    }

    public Ray(double ax, double ay, double bx, double by) {
        super(ax, ay, bx, by);
    }
}
