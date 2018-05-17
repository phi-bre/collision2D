import com.collision.*;
import com.collision.line.Line;
import com.collision.line.Ray;
import com.collision.line.Segment;
import com.collision.shape.Rectangle;
import com.collision.shape.Shape;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test extends Application {

    private int WIDTH, HEIGHT;

    private GraphicsContext gc;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        WIDTH = 512;
        HEIGHT = 512;
        // Initialization
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        canvas = new Canvas(WIDTH, HEIGHT);
        canvas.setFocusTraversable(true);
        canvas.addEventFilter(MouseEvent.ANY, (event) -> canvas.requestFocus());
        root.getChildren().add(canvas);
        primaryStage.show();
        this.gc = canvas.getGraphicsContext2D();

        test4();
    }

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
        Rectangle r2 = new Rectangle(70, 150, 0, 50, 100);
        Rectangle r4 = new Rectangle(70, 150, 0, 50, 100);
        Rectangle r3 = new Rectangle(90, 200, 0, 150, 120);
        shapes.add(r1);
        shapes.add(r2);
        shapes.add(r3);
        shapes.add(r4);
        r2.rotate(15);

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

            renderRectangles(r1, r2, r3, r4);
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

    public void renderRectangles(Rectangle ... rectangles) {
        for (Rectangle rectangle : rectangles) {
            renderSegments(rectangle.getSegments());
        }
    }

    public void renderSegments(Segment ... segments) {
        for (Segment segment : segments) {
            gc.setStroke(Color.BLACK);
            gc.strokeLine(
                    segment.getA().getX(),
                    segment.getA().getY(),
                    segment.getB().getX(),
                    segment.getB().getY()
            );
        }
    }

    public void renderPoints(Point ... points) {
        for (Point point : points) {
            //if (point != null) {
                float size = 5;
                gc.setFill(Color.RED);
                gc.fillOval(point.getX() - size / 2, point.getY() - size / 2, size, size);
            //}
        }
    }

    public void renderRay(Ray ray) {
        Rectangle rectangle = new Rectangle(WIDTH/2, HEIGHT/2, 0, WIDTH, HEIGHT);
        Intersection intersection;
        for (Segment segment : rectangle.getSegments()) {
            if ((intersection = Intersection.getIntersection(ray, segment)) != null) {
                gc.setFill(Color.LIGHTGRAY);
                gc.strokeLine(ray.getA().getX(), ray.getA().getY(), intersection.getX(), intersection.getY());
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
