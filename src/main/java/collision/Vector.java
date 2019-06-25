package collision;

public class Vector extends Point {

    private boolean normalized;
    private Point origin;

    public Vector(double x, double y) {
        super(x, y);
    }

    public Vector(Point t) {
        super(t.x, t.y);
    }

    public Vector(double ox, double oy, double x, double y) {
        super(x, y);
        this.origin = new Point(ox, oy);
    }

    public Vector(Point origin, Point t) {
        super(t.x, t.y);
        this.origin = origin;
    }

    /* STATIC METHODS */

    public static Vector add(Vector v1, Vector v2) {
        double x = v1.x + v2.x;
        double y = v1.y + v2.y;
        return new Vector(x, y);
    }

    public static Vector subtract(Vector v1, Vector v2) {
        double x = v1.x - v2.x;
        double y = v1.y - v2.y;
        return new Vector(x, y);
    }

    public static double dot(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    public static Vector scale(double scalar, Vector vector) {
        return new Vector(vector.x * scalar, vector.y * scalar);
    }

    public static double cross(Vector v1, Vector v2) {
        return v1.x * v2.y - v1.y * v2.x;
    }

    public static Vector normalize(Vector vector) {
        double l = vector.length();
        double x = vector.x / l;
        double y = vector.y / l;
        Vector v = new Vector(x, y);
        v.normalized = true;
        return v;
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

    /* INSTANCE METHODS */

    public double getRotation() {
        //return Math.toDegrees(Math.acos(x / Math.sqrt(x*x + y*y))) + 180;
        double rot = Math.toDegrees(Math.atan2(x, y)) + 180;
        if (rot < 0) {
            rot += 360;
        }
        return rot;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public boolean isNormalized() {
        return normalized;
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

    public Vector normalize() {
        double l = this.length();
        this.x = x / l;
        this.y = y / l;
        normalized = true;
        return this;
    }

    public Point getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Vector{" + "x: " + x + ", y: " + y + '}';
    }

    public static void main(String[] args) {
        Vector d = new Vector(1, -1);
        Vector n = new Vector(0, 1).normalize();
        System.out.println(Vector.scale(-2 * Vector.dot(d, n), n));
        System.out.println(Vector.add(d, Vector.scale(-2 * Vector.dot(d, n), n)));
        //System.out.println(Vector.add(Vector.subtract(d, Vector.scale(Vector.dot(d, n), n)), Vector.scale(Vector.dot(d, n), n)));
    }

}
