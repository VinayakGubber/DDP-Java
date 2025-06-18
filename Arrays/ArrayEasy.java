package Arrays;

import HelperFunctions.HelperFunction;

import java.util.Scanner;

class ArrayProblemsEasy {
    Scanner sc = new Scanner(System.in);

    public void largest() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println("Largest number is : " + largest);
    }

    public void secondLargest() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        int largest = arr[0];
        int sLargest = Integer.MIN_VALUE;
        // This is the lowest possible value stored in the integer..
        boolean found = false;
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
                found = true;
            }
            /*
             * The elsif is written because without it the sLargest is updated only when
             * there exist a greater than the assigned largest and if the assumed arr[0] is
             * the largest it stays un-updated so we use the else if ----WHERE---- we
             * compare if the current element is lesser that the largest && the current
             * element is greater than the Smallest integer assigned
             */
            else if (arr[i] < largest && arr[i] > sLargest) {
                sLargest = arr[i];
                found = true;
            }
        }
        /*
         * This is to tackel the corner case where all the elements are the same and
         * there exist no second largest
         */
        if (!found) {
            System.out.println("There is no second largest element.");
        } else {

            System.out.println("Second largest number is : " + sLargest);
        }
    }
}

public class ArrayEasy {
    public static void main(String[] args) {
        ArrayProblemsEasy ape = new ArrayProblemsEasy();

        // ape.largest();
        ape.secondLargest();

    }
}
