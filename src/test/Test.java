package test;

import com.collision.*;
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

public class Test extends Application {

    private GraphicsContext gc;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialization
        Pane root = new Pane();
        Scene scene = new Scene(root, 512, 512);
        primaryStage.setScene(scene);
        canvas = new Canvas(512, 512);
        canvas.setFocusTraversable(true);
        canvas.addEventFilter(MouseEvent.ANY, (event) -> canvas.requestFocus());
        root.getChildren().add(canvas);
        primaryStage.show();
        this.gc = canvas.getGraphicsContext2D();

        test2();
    }

    public void test1() {
        ArrayList<Shape> shapes = new ArrayList<>();
        Rectangle r1 = new Rectangle(120, 130, 0, 100, 70);
        Rectangle r2 = new Rectangle(70, 150, 0, 50, 100);
        Rectangle r3 = new Rectangle(90, 200, 0, 150, 120);
        shapes.add(r1);
        shapes.add(r2);
        shapes.add(r3);

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

            renderRectangles(r1, r2, r3);
            renderPoints(intersections.toArray(new Intersection[0]));
        }));
    }

    public void test2() {
        Segment s1 = new Segment(100, 100, 200, 200);
        Segment s2 = new Segment(100, 200, 200, 100);

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

    public static void main(String[] args) {
        launch(args);
    }
}
