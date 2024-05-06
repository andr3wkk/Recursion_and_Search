package com.example.recursion_and_search;

public class Part1 {
    // 1.1
    public static int sum1toN(int n) {
        if (n == 1) {
            return 1; // Base case
        }
        return n + sum1toN(n - 1); // Recursive case
    }

    // 1.2
    public static double power(double x, int n) {
        if (n == 0) {
            return 1; // Base case: anything to the power of 0 is 1
        }
        return x * power(x, n - 1); // Recursive case
    }

    public static void main(String[] args) {
        // 1.1
        int sumResult = sum1toN(10);
        System.out.println("Sum of first 10 positive integers is: " + sumResult);

        // 1.2
        double powerResult = power(2, 5);
        System.out.println("2 raised to the power of 5 is: " + powerResult);
    }
}
