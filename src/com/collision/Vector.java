package com.collision;

public class Vector extends Point {

    public Vector(float x, float y) {
        super(x, y);
    }

    public float[] getVector() {
        return new float[]{x, y};
    }

    public void rotate(float a) {
        x = (float) (x * Math.cos(a) + (-Math.sin(a) * y));
        y = (float) (x * Math.sin(a) + (Math.cos(a) * y));
    }

    public void translate(float x, float y) {
        this.x += x;
        this.y += y;
    }

}
