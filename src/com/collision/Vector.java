package com.collision;

public class Vector extends Point {

    public Vector(float x, float y) {
        super(x, y);
    }

    public Vector(Point point) {
        super(point.getX(), point.getY());
    }

    public static Vector add(Vector v1, Vector v2) {
        float x = v1.x + v2.x;
        float y = v1.x + v2.y;
        return new Vector(x, y);
    }

    public static Vector subtract(Vector v1, Vector v2) {
        float x = v1.x - v2.x;
        float y = v1.x - v2.y;
        return new Vector(x, y);
    }

    public static float dot(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    public static float length(Vector v1, Vector v2) {
        return (float) Math.sqrt(dot(v1, v1) + dot(v2, v2));
    }

    public static float cross(Vector v1, Vector v2) {
        return v1.x * v2.y - v1.y * v2.x;
    }

    public float[] getArray() {
        return new float[]{x, y};
    }

    public void rotate(float a) {
        float theta = (float) Math.toRadians(a);
        float x = (float) (this.x * Math.cos(theta) - (Math.sin(theta) * this.y));
        float y = (float) (this.x * Math.sin(theta) + (Math.cos(theta) * this.y));
        this.x = x;
        this.y = y;
    }

    public void translate(float x, float y) {
        this.x += x;
        this.y += y;
    }

}
