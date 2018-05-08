package com.collision;

import java.util.Arrays;

public class Rectangle extends Shape {

    private float w, h;
    private Point p1, p2, p3, p4;

    public Rectangle(float x, float y, float a, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.a = a;

        p1 = new Point(-w / 2, h / 2);
        p2 = new Point(w / 2, h / 2);
        p3 = new Point(w / 2, -h / 2);
        p4 = new Point(-w / 2, -h / 2);

        changed = true;

        // TODO IMPLEMENT ROTATION
    }

    public Point[] getPoints() {
        if (changed) {

            float[][] matrix = new float[][]{
                    {p1.getX(), p2.getX(), p3.getX(), p4.getX()}, {p1.getY(), p2.getY(), p3.getY(), p4.getY()}, {1, 1, 1, 1}
            };

            for (float[] f : matrix) {
                for (float f1 : f) {
                    System.out.print(f1 + ", ");
                }
                System.out.println("");
            }

            float[][] c = Matrix.multiply(new float[][]{{1, 0, x}, {0, 1, y}, {0, 0, 1}}, matrix);

            for (float[] f : c) {
                for (float f1 : f) {
                    System.out.print(f1 + ", ");
                }
                System.out.println("");
            }
            buffer = new Point[4];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = new Point(c[i][0], c[i][1]);
            }
            changed = false;
        }

        return buffer;
    }

    @Override
    public Vector[] getVectors() {
        return new Vector[]{};
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(0, 0, 0, 20, 20);

        Arrays.asList(rectangle.getPoints()).forEach(System.out::println);
        System.out.println("");

        // Translate
//        rectangle.setPosition(100, 0);
//        Arrays.asList(rectangle.getPoints()).forEach(System.out::println);
    }

}
