package com.collision;

public class Polygon extends Shape {

    private Vector[] vectors;

    public Polygon(float x, float y, float a, Vector ... vectors) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.vectors = vectors;
    }

    @Override
    public Vector[] getVectors() {
        return vectors;
    }
}
