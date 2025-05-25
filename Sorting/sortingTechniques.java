package Sorting;

import java.util.*;

import HelperFunctions.HelperFunction;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Sort {
    Scanner sc = new Scanner(System.in);

    public void selectionSort() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[i] > arr[j]) {
                    int minValue = arr[i];
                    arr[i] = arr[j];
                    arr[j] = minValue;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    // endl

    // endl
}

public class sortingTechniques {
    public static void main(String argss[]) {
        Sort sort = new Sort();

        sort.selectionSort();

    }
}
