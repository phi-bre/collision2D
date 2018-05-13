package com.collision;

public class Reflection {

    public static Reflection getReflection(Intersection intersection) {
        float dox = intersection.getX() - intersection.getL1().getA().getX();
        float doy = intersection.getY() - intersection.getL1().getA().getY();
        Vector d = new Vector(dox, doy);
        float nox = intersection.getX() - intersection.getL2().getB().getX();
        float noy = intersection.getY() - intersection.getL2().getB().getY();
        Vector n = new Vector(nox, noy);
        n = Vector.normalize(n);

        Vector r = Vector.subtract(d, (Vector.));
    }
}
