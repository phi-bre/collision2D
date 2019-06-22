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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            Line l = (Line) obj;
            return a.equals(l.a) && b.equals(l.b);
        } else {
            return super.equals(obj);
        }
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
