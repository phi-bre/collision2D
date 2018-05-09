package com.collision;

public class Matrix {

    private float[][] matrix;

    public Matrix(float[][] matrix) {
        this.matrix = matrix;
    }

    public float[][] getMatrix() {
        return matrix;
    }

    // ADDITION ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static float[][] add(float[][] a, float[][] b) {

        int ar = a[0].length;      // A - rows
        int ac = a.length;   // A - columns
        int br = b[0].length;      // B - rows
        int bc = b.length;   // B - columns

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

    public static Matrix add(Matrix a, Matrix b) {
        return a.add(b);
    }

    public float[][] add(float[][] matrix) {
        return Matrix.add(this.matrix, matrix);
    }

    public Matrix add(Matrix matrix) {
        return new Matrix(Matrix.add(this.matrix, matrix.matrix));
    }

    // MULTIPLICATION //////////////////////////////////////////////////////////////////////////////////////////////////

    public static float[][] multiply(float[][] a, float[][] b) {

        int ar = a.length;      // A - rows
        int ac = a[0].length;   // A - columns
        int br = b.length;      // B - rows
        int bc = b[0].length;   // B - columns

        if (ac != br) throw new IllegalArgumentException("Rows: " + ar + " did not match Column: " + bc + ".");

        float[][] c = new float[ar][bc];

        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < bc; j++) {
                for (int k = 0; k < ac; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        return a.multiply(b);
    }

    public float[][] multiply(float[][] matrix) {
        return Matrix.multiply(this.matrix, matrix);
    }

    public Matrix multiply(Matrix matrix) {
        return new Matrix(Matrix.multiply(this.matrix, matrix.matrix));
    }

}
