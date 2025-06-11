package Sorting;

import java.util.*;

import HelperFunctions.HelperFunction;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

class Sort {
    Scanner sc = new Scanner(System.in);

    // Selection sort
    public void selectionSort() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[i] > arr[j]) {
                    int minValue = arr[i];
                    arr[i] = arr[j];
                    arr[j] = minValue;
                    swapped = true;
                }
            }
            if (!swapped) {
                /* This "Early exit" somehow works but did'nt feel like figuring out */
                System.out.println("Early exit");
                break;
            }

        }

        System.out.println(Arrays.toString(arr));

    }

    // Bubble sort
    public void bubbleSort() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            /*
             * This facilitates early exit from code if the array elements are sorted
             * already
             */
            if (!swapped) {
                /* This "Early exit" somehow works but did'nt feel like figuring out */
                System.out.println("Early exit");
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Merge sort
    public void mergeSort() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        int left = (int) (Math.floor((n - 1) / 2));
        System.out.println(left);
    }

    // Insertion sort
    public void insertionSort() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            boolean swapped = false;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];// this basically shifts the element at j to j+1
                j--;
                swapped = true;
            }
            arr[j + 1] = key;
            /*
             * j+1 because we decrement the value of j even before we check the condition//
             * come out of the loop so to insert into correct place we use j+1
             */
            if (!swapped) {
                break;
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

        // sort.selectionSort();
        // sort.bubbleSort();
        // sort.mergeSort();
        sort.insertionSort();

    }
}
