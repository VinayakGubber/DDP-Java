package SDE_Sheet_29_Days;

import java.math.*;
import java.util.Arrays;

public class Day_1 {

    // -----------------------------------------------------------------------------------------------------------//
    /* Start of Set Matrix Zero - BRUTE */
    /* B R U T E */
    /*
     * Fails in case of matrix containing negative numbers
     * 
     * Time complexit is O(MxN)+O(M+N)+O(MxN)
     */
    public void BRUTEsetMatrixZero(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setRow(i, matrix);
                    setColumn(j, matrix);
                }
            }
        }
        set0(matrix);
    }

    public void set0(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setRow(int row, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[row][j] != 0) {
                matrix[row][j] = -1;
            }
        }
    }

    public void setColumn(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }
        }
    }

    /* End of Set Matrix Zero - B R U T E */
    // -----------------------------------------------------------------------------------------------------------//

    // -----------------------------------------------------------------------------------------------------------//
    /* B E T T E R */
    /*
     * Use extra array to mark rows and columns that need to be changed
     * 
     * Time complexity is O(MxN)+O(MxN)
     * Space complexity is O(M)+O(N)
     */

    public void BETTERsetMatrixZero(int[][] matrix) {
        int[] arrRow = new int[matrix.length];
        int[] arrCol = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    arrRow[i] = 1;
                    arrCol[j] = 1;
                }
            }
        }
        set0(matrix, arrRow, arrCol);
    }

    void set0(int[][] matrix, int[] arrRow, int[] arrCol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (arrRow[i] == 1 || arrCol[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /* End of Set Matrix Zero - B E T T E R */

    // -----------------------------------------------------------------------------------------------------------//

    // -----------------------------------------------------------------------------------------------------------//
    /* O P T I M A L */
    /*
     * In this we use the existing matrix's row 1 and column as marker arrays
     * Also use two boolean variables to handle corner case ie, 0's in
     * row 1 and col 1
     * Better than brute in terms of space complexity
     * 
     * Doesnt work for matrix ex: matrix = [[0,1]]
     */

    public void OPTIMALsetMatrixZero(int[][] matrix) {
        boolean col = false;
        boolean row = false;

        int n = matrix.length;
        int m = matrix[0].length;

        // For setting true/false
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                row = true;
                break;
            }
        }

        // For setting true/false
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                col = true;
                break;
            }
        }

        // for traversing form 1,1 to n,m and setting marker to 0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // row
                    matrix[0][j] = 0; // col
                }
            }
        }

        // for traversing from 1,1 to n,m and setting the matrix elements to 0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        if (col) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /* End of Set Matrix Zero - O P T I M A L */

    // -----------------------------------------------------------------------------------------------------------//

    // -----------------------------------------------------------------------------------------------------------//

    /*
     * Start of Maximum subarray - BRUTE
     * we write three nested loops the outermost is to tell the start index each
     * time
     * 
     * and the inner loop is ot iterate from the INDEX I to the last index giving
     * all possible subarrays
     * 
     * the innermost loop is to calculate the sum of the sub arrays and store the
     * newest MAX sum in variable max
     * 
     * Time complexity O(n^3)
     * 
     */
    public void BRUTEmaximumSubarray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                    System.out.print(arr[k] + "  ");
                }
                max = Integer.max(sum, max);
                System.out.print("   ");
            }
            System.out.println("");
        }
        System.out.println(max);
    }

    /* End of Maximum subarray - B R U T E */

    // -----------------------------------------------------------------------------------------------------------//

    // -----------------------------------------------------------------------------------------------------------//
    /*
     * Start of Maximum subarray - B E T T E R
     * we have two arrays one for determining the new start every time
     * 
     * the second for loop is to traverse form INDEX I to the last element
     * also handle the calulating the sum of all the subarrays and then assign the
     * newest max to the variable max
     * 
     * 
     * Time complexity O(n^2)
     */
    public void BETTERMaximumSubArray() {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                max = Integer.max(max, sum);
                System.out.print(arr[j] + "  ");
            }
            System.out.println();
        }

        System.out.println(max);
    }

    /* End of Maximum subarray - B E T T E R */

    // -----------------------------------------------------------------------------------------------------------//
    /*
     * Start of Maximum subarray - O P T I M A L
     * 
     * Here we have a single loop that iterates through the array and follows
     * Kandane's algorithm which says
     * 
     * Ill iterate throught the array and add the elements one by one to variable
     * sum
     * 
     * if the sum is greater that 0 AND the max value ; Ill assign the sum to the
     * max variable
     * 
     * if the sum is smaller that 0 it holds no value for me so I re-initialize the
     * sum to 0
     */
    public void OPTIMALMaximumSubarray() {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int n = arr.length;
        int max = arr[0]; // -2
        int sum = arr[0]; // -2
        int start = 0;
        int end = 0;
        int tempStart = 0;
        for (int i = 1; i < n; i++) {
            sum += arr[i];

            /*
             * && sum > max to ensure the cases like [-2,1,-3,4,-1,2,1,-5,4] dont fail where
             * after the 6 th index we get the 6 - 5 which will be 1 and plus 4 will be 5
             * but the maximim sub array sum is 6
             * 
             */
            if (sum < 0) {
                sum = 0;
                tempStart = i + 1;
            } else if (sum > max) {
                max = sum;
                start = tempStart;
                end = i;
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]
                    + " ");
        }
        System.out.println("");
        System.out.println(max);

    }

    /* End of Maximum subarray - O P T I M A L */

    // -----------------------------------------------------------------------------------------------------------//
    // -----------------------------------------------------------------------------------------------------------//
    /* Start of sort array of "0,1,2" - B R U T E */
    /* Use any sorting alogo example a merge sort which will take O(NlogN) */
    /* End of sort array of "0,1,2" - B R U T E */
    /*
     * Start of sort array of "0,1,2" - B E T T E R
     * 
     * Time complexity would be O(n + n + n + n) = O(4n) ≈ O(n)
     */
    public void BETTERSort012() {
        int[] arr = { 2, 0, 2, 1, 1, 0, 2, 0, 1, 0, 2, 1, 0 };
        int n = arr.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else if (arr[i] == 2) {
                count2++;
            }
        }
        System.out.println(count0 + " " + count1 + " " + count2 + " ");

        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }
        for (int i = count0 + count1; i < n; i++) {
            arr[i] = 2;
        }

        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");

        }
    }

    /* End of sort array of "0,1,2" - B E T T E R */

    // -----------------------------------------------------------------------------------------------------------//

    // -----------------------------------------------------------------------------------------------------------//
    /*
     * Start of sort array of "0,1,2" - O P T I M A L
     * 
     * D U T C H - N A T I O N A L - Flag Algorithm
     * 
     * Time complexity would be at max O(n) and
     * Space complexity just a few variables
     */
    public void OPTIMALSort012() {
        int[] arr = { 2, 0, 2, 1, 1, 0, 2, 0, 1, 0, 2, 1, 0 };
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        int temp;

        while (mid <= high) {
            /*
             * While because we dont know how many iteration would it take
             * Additonally we check until the mid pointer crosses the high
             * because the unsorted hypothetical array is from mid to high
             * so if they cross each other then its sorted
             */
            if (arr[mid] == 0) {
                temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    /* End of sort array of "0,1,2" - O P T I M A L */
    // -----------------------------------------------------------------------------------------------------------//

    // -----------------------------------------------------------------------------------------------------------//
    /*
     * Start of next permutation" - B R U T E
     * We simply get all the permutations of the given numbers in ascending order
     * and then find the next
     */

    /* End of next permutation" - B R U T E */
    // -----------------------------------------------------------------------------------------------------------//
    /* */
    // -----------------------------------------------------------------------------------------------------------//
    /* Start of next permutation" - B E T T E R */
    public int[] BETTERNextPermutation() {
        int[] arr = { 1, 2, 3, 6, 5, 4 };
        int n = arr.length - 1;
        int index = -1;

        // Finding the dip in graph
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            Reverse(arr, 0, n); // reverse entire array
            return arr;
        }

        // Swap logic
        if (index >= 0) {
            for (int i = n; i > index; i--) {
                if (arr[i] > arr[index]) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    break; // stop after first valid swap
                }
            }
        }

        return Reverse(arr, index + 1, n);
        // Reverse the postfix part of array
        //
    }

    public int[] Reverse(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    /* End of next permutation" - B E T T E R */

    // -----------------------------------------------------------------------------------------------------------//

    //
    //
    //
    //
    //
    //
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        // int n = arr.length - 1;
        Day_1 p1 = new Day_1();

        for (int i : p1.BETTERNextPermutation()) {
            System.out.print(i);
            System.out.print(" ");
        }

        // int[] arr = p1.BETTERNextPermutation();
        // for (int i : arr) {
        // System.out.print(i);
        // System.out.print(" ");
        // }

        // p1.Reverse(arr)
    }
}
