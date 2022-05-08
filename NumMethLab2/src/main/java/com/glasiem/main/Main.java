package com.glasiem.main;

import com.glasiem.methods.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double e = 0.001;
        System.out.println("""
                Choose your method
                1.One-shot explicit method
                2.Square root method
                3.Seidel method
                """);
        Scanner in = new Scanner(System.in);
        int methodNum = in.nextInt();
        switch (methodNum) {
            case 1:
                OneShot.runMethod(e);
                break;
            case 2:
                SqRoot.runMethod(e);
                break;
            case 3:
                Seidel.runMethod(e);
                break;
        }
    }
}
