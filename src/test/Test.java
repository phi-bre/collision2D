import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import collision.*;
import collision.line.*;
import collision.shape.*;

public class Test {

    private void test4() {
        Segment segment = new Segment(400, 10, 200, 200);
        Ray ray = new Ray(30, 30, 235, 80);

        canvas.setOnMouseMoved((event -> {
            ray.getB().setPosition(event.getX(), event.getY());
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            Intersection intersection = Intersection.getIntersection(ray, segment);
            if (intersection != null) {
                Reflection reflection = Reflection.getReflection(ray, segment);
                Segment s = new Segment(reflection.getVector(), reflection.getOrigin());
                renderSegments(s);
                renderPoints(intersection);
            }
//            Vector vector = new Vector(Vector.subtract(new Vector(ray.getA()), new Vector(ray.getB())));
//            System.out.println(vector.getRotation());
            renderRay(ray);
            renderSegments(segment);
        }));
    }

    private void test3() {
        ArrayList<Line> lines = new ArrayList<>();
//        Rectangle r1 = new Rectangle(120, 130, 0, 100, 70);
//        Rectangle r2 = new Rectangle(70, 150, 0, 50, 100);
//        Rectangle r3 = new Rectangle(90, 200, 0, 150, 120);
        Ray ray = new Ray(200, 200, 0, 0);
//        lines.addAll(Arrays.asList(r1.getSegments()));
//        lines.addAll(Arrays.asList(r2.getSegments()));
//        lines.addAll(Arrays.asList(r3.getSegments()));
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Segment segment = new Segment(random.nextInt(512), random.nextInt(512), random.nextInt(512), random.nextInt(512));
            lines.add(segment);
        }
        lines.add(ray);

        canvas.setOnMouseMoved((event -> {
            ray.getB().setPosition((float) event.getX(), (float) event.getY());

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            ArrayList<Intersection> intersections = new ArrayList<>();

            for (Line line : lines) {
                for (Line l : lines) {
                    Intersection intersection = Intersection.getIntersection(l, line);
                    if (intersection != null) intersections.add(intersection);
                }
            }

            //renderRectangles(r1, r2, r3);
            for (Line line : lines) {
                if (line instanceof Segment) {
                    renderSegments((Segment) line);
                }
            }
            renderPoints(intersections.toArray(new Intersection[0]));
        }));
    }

    public void test1() {
        ArrayList<Shape> shapes = new ArrayList<>();
        Rectangle r1 = new Rectangle(120, 130, 0, 100, 70);
        //Rectangle r2 = new Rectangle(70, 150, 0, 50, 100);
        Rectangle r4 = new Rectangle(70, 150, 0, 50, 100);
        Rectangle r3 = new Rectangle(90, 200, 0, 150, 120);
        shapes.add(r1);
        //shapes.add(r2);
        shapes.add(r3);
        shapes.add(r4);
        //r2.rotate(15);

        canvas.setOnMouseMoved((event -> {
            r1.setPosition((float) event.getX(), (float) event.getY());

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            ArrayList<Intersection> intersections = new ArrayList<>();

            for (Shape shape : shapes) {
                for (Shape s : shapes) {
                    if (shape != s) {
                        intersections.addAll(Arrays.asList(shape.getIntersections(s)));
                    }
                }
            }

            renderRectangles(r1, r3, r4);
            renderPoints(intersections.toArray(new Intersection[0]));
        }));
    }

    public void test2() {
        Segment s1 = new Segment(100, 100, 200, 200);
        Segment s2 = new Segment(300, 230, 100, 200);

        Intersection intersection = Intersection.getIntersection(s1, s2);

        renderSegments(s1, s2);
        if (intersection != null) renderPoints(intersection);
    }

    public Intersection[] getIntersections(Shape ... shapes) {
        ArrayList<Intersection> intersections = new ArrayList<>();

        for (Shape shape : shapes) {
            for (Shape s : shapes) {
                if (shape != s) {
                    intersections.addAll(Arrays.asList(shape.getIntersections(s)));
                }
            }
        }

        return intersections.toArray(new Intersection[0]);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
