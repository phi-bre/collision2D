package com.collision;

public abstract class Matrix {

    public static double[][] inverse(double[][] a) {

        int ar = a[0].length;
        int ac = a.length;

        double[][] c = new double[ar][ac];

        for (int i = 0; i < ac; i++) {
            for (int j = 0; j < ar; j++) {
                c[i][j] = -a[i][j];
            }
        }

        return c;
    }

    public static double[][] addition(double[][] a, double[][] b) {

        int ar = a[0].length; // A - rows
        int ac = a.length;    // A - columns
        int br = b[0].length; // B - rows
        int bc = b.length;    // B - columns

        if (ar != br) throw new IllegalArgumentException("Rows of the matrices don't match");
        else if (ac != bc) throw new IllegalArgumentException("Columns of the matrices don't match");

        double[][] c = new double[ac][ar];

        for (int i = 0; i < ac; i++) {
            for (int j = 0; j < ar; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    public static double[][] subtraction(double[][] a, double[][] b) {

        int ar = a[0].length; // A - rows
        int ac = a.length;    // A - columns
        int br = b[0].length; // B - rows
        int bc = b.length;    // B - columns

        if (ar != br) throw new IllegalArgumentException("Rows of the matrices don't match");
        else if (ac != bc) throw new IllegalArgumentException("Columns of the matrices don't match");

        double[][] c = new double[ac][ar];

        for (int i = 0; i < ac; i++) {
            for (int j = 0; j < ar; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }

        return c;
    }

    public static double[][] multiplication(double[][] a, double[][] b) {

        int ar = a[0].length; // A - rows
        int ac = a.length;    // A - columns
        int br = b[0].length; // B - rows
        int bc = b.length;    // B - columns

        if (ac != br) throw new IllegalArgumentException("Rows: " + ac + " did not match Column: " + br + ".");

        double[][] c = new double[bc][ar];

        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < bc; j++) {
                for (int k = 0; k < ac; k++) {
                    c[j][i] += a[k][i] * b[j][k];
                }
            }
        }

        return c;
    }

    public static double[][] translation(double x, double y, double[][] m) {
        double[][] t = new double[][]{{1, 0, 0}, {0, 1, 0}, {x, y, 1}};
        double[][] mt = new double[m.length][3];
        for (int i = 0; i < m.length; i++) {
            mt[i][0] = m[i][0];
            mt[i][1] = m[i][1];
            mt[i][2] = 1;
        }
        return multiplication(t, mt);
    }

    public static double[][] rotation(double angle, double[][] m) {
        double[][] r;
        double a = Math.toRadians(-angle);

        if (m[0].length > 2) throw new IllegalArgumentException("Invalid rows, only x and y are expected.");

        if (angle == 90 || angle == -270) {
             r = new double[][]{{0, -1}, {1, 0}};
        } else if (angle == 180 || angle == -180) {
            r = new double[][]{{-1, 0}, {0, -1}};
        } else if (angle == 270 || angle == -90) {
            r = new double[][]{{0, 1}, {-1, 0}};
        } else {
            r = new double[][]{{Math.cos(a), -Math.sin(a)}, {Math.sin(a), Math.cos(a)}};
        }

        return multiplication(r, m);
    }

    public static void main(String[] args) {
        double[][] a = new double[][]{{0, 0}, {10, 10}};
        double[][] b = new double[][]{{20, 5}, {30, 6}, {0, 20}};

        double[][] c = Matrix.rotation(90, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println("x: " + c[i][0] + ", y: " + c[i][1]);
        }
    }

}
