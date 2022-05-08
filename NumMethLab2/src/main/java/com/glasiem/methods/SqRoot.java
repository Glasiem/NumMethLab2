package com.glasiem.methods;

public class SqRoot {
    private static double[][] matrix = {
            {1,2,0},
            {2,2,4},
            {0,4,3}
    };

    private static double[] result = {5, 22, 20};

    private static double[][] rightTriangle = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };

    private static double[][] diagonal = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };

    private static double[][] finalMatrix = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };
    
    private static double[] y ={0,0,0};

    private static double[] x ={0,0,0};

    public static void runMethod(double e) {
        System.out.println("Initial matrix:");
        Operations.printMatrix(matrix);
        System.out.println('\n');
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += Math.pow(Math.abs(rightTriangle[j][i]),2)*diagonal[j][j];
            }
            diagonal[i][i] = Math.signum(matrix[i][i] - sum);
            rightTriangle[i][i] = Math.sqrt(Math.abs(matrix[i][i] - sum));
            for (int j = i+1; j < matrix[0].length; j++) {
                sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += rightTriangle[k][i]*diagonal[k][k]*rightTriangle[k][j];
                }
                rightTriangle[i][j] = (matrix[i][j] - sum)/(diagonal[i][i]*rightTriangle[i][i]);
            }
        }
        finalMatrix = Operations.multiply(Operations.transpose(rightTriangle),diagonal);
        for (int i = 0; i < y.length; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += finalMatrix[i][j]*y[j];
            }
            y[i] = (result[i] - sum)/finalMatrix[i][i];
        }
        for (int i = x.length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < x.length ; j++) {
                sum += rightTriangle[i][j]*x[j];
            }
            x[i] = (y[i] - sum)/rightTriangle[i][i];
        }
        System.out.print("\t");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("x"+i+'\t'+'\t');
        }
        System.out.println('\n');
        Operations.printMatrix(x);
        System.out.println('\n');
        System.out.print("Determinant: ");
        System.out.printf("%8.3f", Operations.getDeterminant(matrix));
        System.out.println('\n');
        System.out.println("Inverse matrix:");
        Operations.printMatrix(Operations.getInverse(matrix));
    }

}
