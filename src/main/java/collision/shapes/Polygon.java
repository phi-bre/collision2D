package collision.shapes;

import collision.Intersection;
import collision.Vector;

import java.util.ArrayList;

public class Polygon extends Shape {

    protected Vector[] vectors;
    protected Vector[] segments;

    public Polygon(double x, double y, double a, Vector ... vectors) {
        this.vectors = vectors;
        segments = new Vector[vectors.length];
        for (int i = 0; i < segments.length; i++) {
            if (i == segments.length - 1) {
                segments[i] = new Vector(vectors[i], vectors[0]);
            } else {
                segments[i] = new Vector(vectors[i], vectors[i + 1]);
            }
        }

        translate(x, y);
        rotate(a);
    }

    @Override
    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
        for (int i = 0; i < segments.length; i++) {
            segments[i].setPosition(
                    vectors[i].getX() + this.x,
                    vectors[i].getY() + this.y
            );
        }
    }

    private static final double[][] R1 = new double[][]{{0, -1}, {1, 0}};
    private static final double[][] R2 = new double[][]{{-1, 0}, {0, -1}};
    private static final double[][] R3 = new double[][]{{0, 1}, {-1, 0}};

    @Override
    public void rotate(double angle) {
        this.a = angle;
        double a = Math.toRadians(-this.a);
        double[][] r;

        if (angle == 90 || angle == -270) {
            r = R1;
        } else if (angle == 180 || angle == -180) {
            r = R2;
        } else if (angle == 270 || angle == -90) {
            r = R3;
        } else {
            r = new double[][]{{Math.cos(a), -Math.sin(a)}, {Math.sin(a), Math.cos(a)}};
        }

        for (int i = 0; i < segments.length; i++) {
            Vector v = vectors[i];
            segments[i].setPosition(
                    v.getX() * r[0][0] + v.getY() * r[0][1],
                    v.getX() * r[1][0] + v.getY() * r[1][1]
            );
        }
    }

    @Override
    public Intersection[] getIntersections(Shape shape) {
        ArrayList<Intersection> intersections = new ArrayList<>();

        if (shape instanceof Polygon) {
            for (Vector segment : segments) {
                for (Vector s : ((Polygon) shape).segments) {
                    Intersection i = Intersection.getIntersection(segment, s);
                    if (i != null) intersections.add(i);
                }
            }
        }

        return intersections.toArray(new Intersection[0]);
    }

    @Override
    public boolean intersects(Shape shape) {
        if (shape instanceof Polygon) {
            for (Vector segment : segments) {
                for (Vector s : ((Polygon) shape).segments) {
                    Intersection i = Intersection.getIntersection(segment, s);
                    if (i != null) return true;
                }
            }
        }
        return false;
    }

    public Vector[] getVectors() {
        return vectors;
    }

    public Vector[] getSegments() {
        return segments;
    }

}
