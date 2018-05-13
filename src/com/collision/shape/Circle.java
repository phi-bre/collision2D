package com.collision.shape;

import com.collision.Intersection;

public class Circle extends Shape {

    private float r;

    public Circle(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.r = radius;
    }

    public float getRadius() {
        return r;
    }

    public void setRadius(float r) {
        this.r = r;
    }

    @Override
    public void update() {
        // nothing
    }

    @Override
    public Intersection[] getIntersections(Shape shape) {
        return null;
    }

    @Override
    public void translate(float x, float y) {
        this.setPosition(this.x + x, this.y + y);
    }

    @Override
    public void rotate(float a) {
        // nothing
    }
}
