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

//    public static float length(Vector v1, Vector v2) {
//        return (float) Math.sqrt(dot(v1, v1) + dot(v2, v2));
//    }

    public static float cross(Vector v1, Vector v2) {
        return v1.x * v2.y - v1.y * v2.x;
    }

    public static Vector normalize(Vector vector) {
        float l = vector.length();
        float x = vector.x / l;
        float y = vector.y / l;
        return new Vector(x, y);
    }

    public static Vector rotate(Vector vector, float a) {
        float x, y;

        // Optimized for special angles
        if (a == 90 || a == -270) {
            x = vector.y;
            y = -vector.x;
        } else if (a == 180 || a == -180) {
            x = -vector.x;
            y = -vector.y;
        } else if (a == 270 || a == -90) {
            x = -vector.y;
            y = vector.x;
        } else {
            // For any other angle
            float theta = (float) Math.toRadians(a);
            x = (float) (vector.x * Math.cos(theta) - (Math.sin(theta) * vector.y));
            y = (float) (vector.x * Math.sin(theta) + (Math.cos(theta) * vector.y));
        }

        return new Vector(x, y);
    }

    public float[] asArray() {
        return new float[]{x, y};
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public void rotate(float a) {
        float x, y;

        // Optimized for special angles
        if (a == 90) {
            x = this.y;
            y = -this.x;
        } else if (a == 180) {
            x = -this.x;
            y = -this.y;
        } else if (a == 270) {
            x = -this.y;
            y = this.x;
        } else {
            // For any other angle
            float theta = (float) Math.toRadians(a);
            x = (float) (this.x * Math.cos(theta) - (Math.sin(theta) * this.y));
            y = (float) (this.x * Math.sin(theta) + (Math.cos(theta) * this.y));
        }

        this.x = x;
        this.y = y;
    }

    public void translate(float x, float y) {
        this.x += x;
        this.y += y;
    }

}
