package com.collision.shape;

import com.collision.Intersection;

public class Circle extends Shape {

    private double r;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.r = radius;
    }

    public double getRadius() {
        return r;
    }

    public void setRadius(double r) {
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
    public void translate(double x, double y) {
        this.setPosition(this.x + x, this.y + y);
    }

    @Override
    public void rotate(double a) {
        // nothing
    }
}
