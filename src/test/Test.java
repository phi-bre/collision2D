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

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialization
        Pane root = new Pane();
        Scene scene = new Scene(root, 512, 512);
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(512, 512);
        canvas.setFocusTraversable(true);
        canvas.addEventFilter(MouseEvent.ANY, (event) -> canvas.requestFocus());
        root.getChildren().add(canvas);
        primaryStage.show();
        this.gc = canvas.getGraphicsContext2D();

        Vector v1 = new Vector(100, 100, 400, 400);
        Vector v2 = new Vector(200, 100, 100, 200);
        Rectangle r1 = new Rectangle(300, 300, 150, 200, 0);

        canvas.setOnMouseMoved((event -> {
            r1.setPosition((float) event.getX(), (float) event.getY());

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            renderVectors(v1, v2);
            renderRectangles(r1);

            Intersection[] intersections = r1.getIntersections(new Polygon(0, 0, 0, v1));
            renderPoints(intersections);
        }));
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
            renderVectors(rectangle.getVectors());
        }
    }

    public void renderVectors(Vector ... vectors) {
        for (Vector vector : vectors) {
            gc.setStroke(Color.BLACK);
            gc.strokeLine(
                    vector.getA().getX(),
                    vector.getA().getY(),
                    vector.getB().getX(),
                    vector.getB().getY()
            );
        }
    }

    public void renderPoints(Point ... points) {
        for (Point point : points) {
            float size = 5;
            gc.setFill(Color.RED);
            gc.fillOval(point.getX() - size / 2, point.getY() - size / 2, size, size);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
