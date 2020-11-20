package com.collision.shape;

import com.collision.Vector;

public class Rectangle extends Polygon {

    private double w, h;

    public Rectangle(double x, double y, double a, double w, double h) {
        super(
            x, y, a,
            new Vector(-w / 2, h / 2),
            new Vector(w / 2, h / 2),
            new Vector(w / 2, -h / 2),
            new Vector(-w / 2, -h / 2)
        );
        this.w = w;
        this.h = h;
    }

}
