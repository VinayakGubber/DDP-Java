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

        if (n < 2) {
            System.out.println("There should be atleast two elements!!");
            return;
        }

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

    public void sortedOrNot() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        if (n < 2) {
            System.out.println("There should be atleast two elements!!");
            return;
        }

        boolean bool = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                bool = true;
            } else {
                bool = false;
            }
        }
        String result = bool ? "Sorted" : "Not sorted";
        System.out.println();
        System.out.println(result);
    }

    public void removeDuplicate() {
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = HelperFunction.arrayInput(n);

        if (n < 2) {
            System.out.println("There should be atleast two elements!!");
            return;
        }

        // Logic written by me (crude)
        // int index = 0;
        // for (int i = 1; i < n;) {
        // int unq = arr[i - 1];
        // if (unq == arr[i]) {
        // i++;
        // } else if (unq < arr[i]) {
        // arr[index] = arr[i - 1];
        // unq = arr[i];
        // i++;
        // index++;
        // }
        // }
        // This is to handle the case where the unique element is in the last position
        // ie, 1 1 2 2 3 then the last element is not updated in the array so we update
        // it with the
        // if (arr[n - 2] != arr[n - 1]) {
        // arr[index] = arr[n - 1];
        // index++;
        // }

        // Optimized version
        /*
         * This is better than the above because it doesnt use an extra variable to
         * store the value we need to compare as it is alread stored in the arr[index]
         * and instead of if block where we checked for equality and did no operation
         * other than incrementing i here we check for just
         * if(arr[index] != arr[i]) the unique element is not equal to the current then
         * increment the index and add the current element to the index
         * We earlier incremented the i value in both if and else block so instead write
         * a for loop with the increment (No repetation)
         * and also handle the last element
         * 
         * 
         * 
         * Key Takeaways :
         * *check for variabe that can be used in a optimised way like we did with the
         * index here and also some unit operations like i++ and also the index acts as
         * the total number of unique elements that we need to return
         */
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arr[index] != arr[i]) {
                index++;
                arr[index] = arr[i];
            }
        }

        // Clean Up loop
        for (int j = index + 1; j < n; j++) {
            System.out.println();
            arr[j] = -1;
        }

        // Printing loop
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }

        System.out.println();
        String isORare = (index < 2) ? "is" : "are";
        System.out.println("The total unique elements present in the array " + isORare + " : " + (index + 1));
    }
    // TO perform mathematical operations in SOUT use parenthesis

    //

    //

    //
}

public class ArrayEasy {
    public static void main(String[] args) {
        ArrayProblemsEasy ape = new ArrayProblemsEasy();

        // ape.largest();
        // ape.secondLargest();
        // ape.sortedOrNot();
        ape.removeDuplicate();

    }
}
