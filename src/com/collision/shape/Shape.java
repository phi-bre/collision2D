package com.collision.shape;

import com.collision.Intersection;

public abstract class Shape {

    protected double x, y, a;

    protected abstract void update();
    public abstract Intersection[] getIntersections(Shape shape);
    public abstract void translate(double x, double y);
    public abstract void rotate(double a);

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
        this.update();
    }

    public void setAngle(double a) {
        this.a = a;
        this.update();
    }

    public void setX(double x) {
        this.x = x;
        this.update();
    }

    public void setY(double y) {
        this.y = y;
        this.update();
    }

}
