package com.collision;

import java.util.Arrays;

public class Rectangle extends Polygon {

    private float w, h;
    private Point p1, p2, p3, p4;

    public Rectangle(float x, float y, float a, float w, float h) {
        super(x, y, a);
        this.w = w;
        this.h = h;

        p1 = new Point(-w / 2, h / 2);
        p2 = new Point(w / 2, h / 2);
        p3 = new Point(w / 2, -h / 2);
        p4 = new Point(-w / 2, -h / 2);

        this.points = new Point[]{p1, p2, p3, p4};

        // TODO IMPLEMENT ROTATION
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(0, 0, 0, 20, 20);
        rectangle.setPosition(100, 0);

        Arrays.asList(rectangle.getPoints()).forEach(System.out::println);
        System.out.println("");

        // Translate
//        rectangle.setPosition(100, 0);
//        Arrays.asList(rectangle.getPoints()).forEach(System.out::println);
    }

}
