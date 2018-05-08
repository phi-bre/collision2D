package com.collision;

public class Rectangle extends Shape {

    private float w, h;
    private Vector v1, v2, v3, v4;

    public Rectangle(float x, float y, float a, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.a = a;

        v1 = new Vector(-w/2, h/2, w/2, h/2);
        v2 = new Vector(w/2, h/2, w/2, -h/2);
        v3 = new Vector(w/2, -h/2, -w/2, -h/2);
        v4 = new Vector(-w/2, -h/2, -w/2, h/2);

        // TODO IMPLEMENT ROTATION
    }

    @Override
    public Vector[] getVectors() {
        return new Vector[]{v1, v2, v3, v4};
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

}
