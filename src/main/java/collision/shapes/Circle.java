package collision.shapes;

import collision.Intersection;

public class Circle extends Shape {

    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getRadius() {
        return r;
    }

    public void setRadius(double r) {
        this.r = r;
    }

    @Override
    public Intersection[] getIntersections(Shape shape) {
        return null; // TODO: Implement method
    }

    @Override
    public boolean intersects(Shape shape) {
        return false; // TODO: Implement method
    }

    @Override
    public void translate(double x, double y) {
        this.setPosition(this.x + x, this.y + y);
    }

    @Override
    public void rotate(double a) {
        // nothing
    }
}
