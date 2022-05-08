package com.glasiem.methods;

public class Operations {

    static public double[][] multiply(double[][] matrix1, double[][] matrix2) {
        double[][] res = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return res;
    }

    static public double[] multiply(double[][] matrix, double[] column) {
        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[i] += matrix[i][j] * column[j];
            }
        }
        return res;
    }

    static public double[] multiply(double[] matrix, double coef) {
        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            res[i] += matrix[i] * coef;
        }
        return res;
    }

    static public void printMatrix(double[][] matrix) {
        for (double[] rows : matrix) {
            for (double column : rows) {
                System.out.printf("%8.3f", column);
            }
            System.out.println();
        }
    }

    static public void printMatrix(double[] matrix) {
        for (double column : matrix) {
            System.out.printf("%8.3f", column);
        }
    }

    static public double[] subtract(double[] matrix1, double[] matrix2) {
        double[] res = new double[matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            res[i] += matrix1[i] - matrix2[i];
        }
        return res;
    }

    static public double[][] transpose(double[][] matrix) {
        double[][] res = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }

    static public double getDeterminant(double[][] matrix) {
        double[][] res = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        double determ = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j > i; j--) {
                double coef = res[j][i];
                for (int k = 0; k < matrix[0].length; k++) {
                    res[j][k] = res[j][k] - res[i][k] * coef / res[i][i];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            determ *= res[i][i];
        }
        return determ;
    }

    static public double[][] getInverse(double[][] matrix) {
        double[][] res = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        double[][] e = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    e[i][j] = 1;
                } else {
                    e[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j > i; j--) {
                double coef1 = res[j][i];
                for (int k = 0; k < matrix[0].length; k++) {
                    res[j][k] = res[j][k] - res[i][k] * coef1 / res[i][i];
                    e[j][k] = e[j][k] - e[i][k] * coef1 / res[i][i];
                }
            }
        }
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                double coef1 = res[j][i];
                for (int k = 0; k < matrix[0].length; k++) {
                    res[j][k] = res[j][k] - res[i][k] * coef1 / res[i][i];
                    e[j][k] = e[j][k] - e[i][k] * coef1 / res[i][i];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                e[i][j] /= res[i][i];
            }
        }
        return e;
    }
}
