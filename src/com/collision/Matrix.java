package com.collision;

public class Matrix {

    private float[][] matrix;

    public Matrix(float[][] matrix) {
        this.matrix = matrix;
    }

    public float[][] multiply(float[][] a, float[][] b) {

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
}
