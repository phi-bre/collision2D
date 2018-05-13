package com.collision.line;

import com.collision.Point;

public class Ray extends Line {

    public Ray(Point a, Point b) {
        super(a, b);
    }

    public Ray(float ax, float ay, float bx, float by) {
        super(ax, ay, bx, by);
    }
}
