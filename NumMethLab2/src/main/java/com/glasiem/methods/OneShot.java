package com.glasiem.methods;

public class OneShot {
    private static double[][] matrix = {
            {5, 1, 1, 0},
            {1, 2, 0, 0},
            {1, 0, 4, 2},
            {0, 0, 2, 3}
    };

    private static double[] result =  {17, 8, 28, 23};
    private static double[] x0 = {0,0,0,0};
    private static double[] x1 = {0,0,0,0};
    private static final double t = 0.266524;

    public static void runMethod(double e) {
        System.out.println("Initial matrix:");
        Operations.printMatrix(matrix);
        System.out.println('\n');
        for (int i = 0; i < 100; i++) {
            x1 = Operations.subtract(x0, Operations.multiply(Operations.subtract(Operations.multiply(matrix,x0),result),t));
            if ((Math.abs(x1[0] - x0[0]) < e) && (Math.abs(x1[1] - x0[1]) < e) && (Math.abs(x1[2] - x0[2]) < e) && (Math.abs(x1[3] - x0[3]) < e)){
                break;
            }
            for (int j = 0; j < x0.length; j++) {
                x0[j] = x1[j];
            }
        }
        System.out.print("\t");
        for (int i = 0; i < x1.length; i++) {
            System.out.printf("x"+i+'\t'+'\t');
        }
        System.out.println('\n');
        Operations.printMatrix(x1);
    }
}
