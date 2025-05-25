package HelperFunctions;

import java.util.Scanner;

public class HelperFunction {

    // Count digits of a number
    public static int count(int number) {
        int digits = 0;
        while (number > 0) {
            digits++;
            number /= 10;
        }
        return digits;
    }

    // Power function (base^exponent)
    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 1; i <= exponent; ++i) {
            result *= base;
        }
        return result;
    }

    public static int[] arrayInput(int n) {
        Scanner sc = new Scanner(System.in);
        // Initialize empty array
        int[] arr = new int[n];

        // Take array input of size n
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + i + " th element : ");
            arr[i] = sc.nextInt();
        }

        // print array
        // for (int i = 0; i < n; i++) {
        // System.out.print(arr[i]);
        // if (i < n - 1) {
        // System.out.print(", ");
        // }
        // }

        return arr;
    }
}
