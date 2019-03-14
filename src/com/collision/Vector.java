package com.collision;

public class Vector extends Point {

    public Vector(double x, double y) {
        super(x, y);
    }

    public Vector(Point point) {
        super(point.getX(), point.getY());
    }

    public static Vector add(Vector v1, Vector v2) {
        double x = v1.x + v2.x;
        double y = v1.x + v2.y;
        return new Vector(x, y);
    }

    public static Vector subtract(Vector v1, Vector v2) {
        double x = v1.x - v2.x;
        double y = v1.x - v2.y;
        return new Vector(x, y);
    }

    public static double dot(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    public static Vector multiplication(double scalar, Vector vector) {
        return new Vector(vector.x * scalar, vector.y * scalar);
    }

//    public static double length(Vector v1, Vector v2) {
//        return (double) Math.sqrt(dot(v1, v1) + dot(v2, v2));
//    }

    public static double cross(Vector v1, Vector v2) {
        return v1.x * v2.y - v1.y * v2.x;
    }

    public static Vector normalize(Vector vector) {
        double l = vector.length();
        double x = vector.x / l;
        double y = vector.y / l;
        return new Vector(x, y);
    }

    public static Vector rotate(Vector vector, double a) {
        double x, y;

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
            double theta = Math.toRadians(a);
            double cos = Math.cos(theta);
            double sin = Math.sin(theta);
            x = vector.x * cos - (sin * vector.y);
            y = vector.x * sin + (cos * vector.y);
        }

        return new Vector(x, y);
    }

    public double getRotation() {
        //return Math.toDegrees(Math.acos(x / Math.sqrt(x*x + y*y))) + 180;
        double rot = Math.toDegrees(Math.atan2(x, y)) + 180;
        if (rot < 0) {
            rot += 360;
        }
        return rot;
    }

    public double[] toArray() {
        return new double[]{x, y};
    }

    public void fromArray(double[] array) {
        this.x = array[0];
        this.y = array[1];
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public void rotate(double a) {
        double x, y;

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
            double theta = Math.toRadians(a);
            x = this.x * Math.cos(theta) - (Math.sin(theta) * this.y);
            y = this.x * Math.sin(theta) + (Math.cos(theta) * this.y);
        }

        this.x = x;
        this.y = y;
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

}
