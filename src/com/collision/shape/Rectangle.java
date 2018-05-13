package com.collision.shape;

import com.collision.Vector;

public class Rectangle extends Polygon {

    private float w, h;

    public Rectangle(float x, float y, float a, float w, float h) {
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
