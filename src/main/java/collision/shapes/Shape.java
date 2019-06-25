package collision.shapes;

import collision.Intersection;

public abstract class Shape {

    protected double x, y, a;

    public abstract Intersection[] getIntersections(Shape shape);
    public abstract boolean intersects(Shape shape);
    public abstract void translate(double x, double y);
    public abstract void rotate(double a);

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getA() {
        return a;
    }
}
