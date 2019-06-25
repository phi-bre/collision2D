package visual;

import collision.Intersection;
import collision.Point;
import collision.Vector;
import collision.shapes.Rectangle;
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
            renderVectors(rectangle.getSegments());
        }
    }

    public void renderVectors(Vector... segments) {
        gc.setStroke(Color.BLACK);
        for (Vector segment : segments) {
            gc.strokeLine(
                    segment.getOrigin().getX(),
                    segment.getOrigin().getY(),
                    segment.getX(),
                    segment.getY()
            );
        }
    }

    public void renderPoints(Point ... points) {
        gc.setFill(Color.RED);
        for (Point point : points) {
            double size = 5;
            gc.fillOval(point.getX() - size / 2, point.getY() - size / 2, size, size);
        }
    }

    public void renderRays(Vector ... rays) {
        gc.setFill(Color.LIGHTGRAY);
        for (Vector ray : rays) {
            Vector outer = Vector.scale(WIDTH * 2, ray);
            gc.strokeLine(ray.getOrigin().getX(), ray.getOrigin().getY(), outer.getX(), outer.getY());
        }
    }
}
