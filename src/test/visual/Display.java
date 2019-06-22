package visual;

import collision.Intersection;
import collision.Point;
import collision.line.Ray;
import collision.line.Segment;
import collision.shape.Rectangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Display extends Application {

    protected final int WIDTH = 512, HEIGHT = 512;
    protected GraphicsContext gc;
    protected Canvas canvas;

    public Display() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        // START
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
}
