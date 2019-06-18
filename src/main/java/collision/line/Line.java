package collision.line;

import collision.Point;

public abstract class Line {

    protected Point a, b;

    public Line(double ax, double ay, double bx, double by) {
        this.a = new Point(ax, ay);
        this.b = new Point(bx, by);
    }

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }
}
