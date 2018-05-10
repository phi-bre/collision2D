package com.collision;

public abstract class Shape {

    protected float x, y, a;

    protected abstract void update();
    public abstract Intersection[] getIntersections(Shape shape);
    public abstract void translate(float x, float y);
    public abstract void rotate(float a);

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        this.update();
    }

    public void setAngle(float a) {
        this.a = a;
        this.update();
    }

    public void setX(float x) {
        this.x = x;
        this.update();
    }

    public void setY(float y) {
        this.y = y;
        this.update();
    }

}
