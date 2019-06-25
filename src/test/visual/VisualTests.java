package visual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import collision.*;
import collision.shapes.*;

import javafx.stage.Stage;

public class VisualTests extends Display {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        super.start(primaryStage);
        //test4();
        test4();
    }

    private void test4() {
        Vector segment = new Vector(100, 400, 400, 200);
        Vector ray = new Vector(0, 0, 0, 0).normalize();

        canvas.setOnMouseMoved((event -> {
            ray.setPosition(event.getX(), event.getY());
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            Vector n = new Vector(segment.getOrigin(), Vector.add(Vector.rotate(Vector.subtract(segment, new Vector(segment.getOrigin())), 90), new Vector(segment.getOrigin())));
            renderVectors(n);

            Intersection intersection = Intersection.getIntersection(ray, segment);
            if (intersection != null) {
                Reflection reflection = Reflection.getReflection(ray, segment);
                Vector s = new Vector(reflection.getVector(), reflection.getOrigin());
                renderVectors(s);
                renderPoints(intersection);
            }

            renderRays(ray);
            renderVectors(segment);
        }));
    }

    private void test3() {
        ArrayList<Vector> lines = new ArrayList<>();
//        Rectangle r1 = new Rectangle(120, 130, 0, 100, 70);
//        Rectangle r2 = new Rectangle(70, 150, 0, 50, 100);
//        Rectangle r3 = new Rectangle(90, 200, 0, 150, 120);
        Vector ray = new Vector(200, 200, 0, 0).normalize();
//        lines.addAll(Arrays.asList(r1.getSegments()));
//        lines.addAll(Arrays.asList(r2.getSegments()));
//        lines.addAll(Arrays.asList(r3.getSegments()));
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Vector segment = new Vector(random.nextInt(512), random.nextInt(512), random.nextInt(512), random.nextInt(512));
            lines.add(segment);
        }
        lines.add(ray);

        canvas.setOnMouseMoved((event -> {
            ray.setPosition(event.getX(), event.getY());

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            ArrayList<Intersection> intersections = new ArrayList<>();

            for (Vector line : lines) {
                for (Vector l : lines) {
                    Intersection intersection = Intersection.getIntersection(l, line);
                    if (intersection != null) intersections.add(intersection);
                }
            }

            //renderRectangles(r1, r2, r3);
            for (Vector line : lines) {
                renderVectors(line);
            }
            renderPoints(intersections.toArray(new Intersection[0]));
        }));
    }

    public void test2() {
        Vector s1 = new Vector(100, 100, 200, 200);
        Vector s2 = new Vector(300, 130, 100, 200);

        renderPoints(s1, s2);
        Intersection intersection = Intersection.getIntersection(s1, s2);

        renderVectors(s1, s2);
        if (intersection != null) renderPoints(intersection);
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

}
