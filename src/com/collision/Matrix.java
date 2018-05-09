package com.collision;

public abstract class Matrix {

    public static float[][] inverse(float[][] a) {

        int ar = a[0].length;
        int ac = a.length;

        float[][] c = new float[ar][ac];

        for (int i = 0; i < ac; i++) {
            for (int j = 0; j < ar; j++) {
                c[i][j] = -a[i][j];
            }
        }

        return c;
    }

    public static float[][] addition(float[][] a, float[][] b) {

        int ar = a[0].length; // A - rows
        int ac = a.length;    // A - columns
        int br = b[0].length; // B - rows
        int bc = b.length;    // B - columns

        if (ar != br) throw new IllegalArgumentException("Rows of the matrices don't match");
        else if (ac != bc) throw new IllegalArgumentException("Columns of the matrices don't match");

        float[][] c = new float[ac][ar];

        for (int i = 0; i < ac; i++) {
            for (int j = 0; j < ar; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    public static float[][] subtraction(float[][] a, float[][] b) {

        int ar = a[0].length; // A - rows
        int ac = a.length;    // A - columns
        int br = b[0].length; // B - rows
        int bc = b.length;    // B - columns

        if (ar != br) throw new IllegalArgumentException("Rows of the matrices don't match");
        else if (ac != bc) throw new IllegalArgumentException("Columns of the matrices don't match");

        float[][] c = new float[ac][ar];

        for (int i = 0; i < ac; i++) {
            for (int j = 0; j < ar; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }

        return c;
    }

    public static float[][] multiplication(float[][] a, float[][] b) {

        int ar = a[0].length; // A - rows
        int ac = a.length;    // A - columns
        int br = b[0].length; // B - rows
        int bc = b.length;    // B - columns

        if (ac != br) throw new IllegalArgumentException("Rows: " + ac + " did not match Column: " + br + ".");

        float[][] c = new float[ar][bc];

        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < bc; j++) {
                for (int k = 0; k < ac; k++) {
                    c[j][i] += a[k][i] * b[j][k];
                }
            }
        }

        return c;
    }

    public static void main(String[] args) {
        float[][] a = new float[][]{{0, 0, 2}, {10, 10, 130}, {0, 20, 10}};
        float[][] b = new float[][]{{20, 5, 0}, {30, 6, 5}, {0, 1, 10}};

        float[][] c = Matrix.multiplication(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i][0] + ", " + c[i][1] + ", " + c[i][2]);
        }
    }

}
