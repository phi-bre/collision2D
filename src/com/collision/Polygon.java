package com.collision;

public class Polygon extends Shape {

    public Polygon(float x, float y, float a, Point ... points) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.points = points;
    }

    public Polygon(float x, float y, float a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    @Override
    public void setPosition(float x, float y) {

    }

    @Override
    public void setAngle(float a) {

    }

    @Override
    public void setX(float x) {

    }

    @Override
    public void setY(float y) {

    }
}
