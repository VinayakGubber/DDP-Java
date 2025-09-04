package SDE_Sheet_29_Days;

public class Day_1 {
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

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                row = true;
                break;
            }
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                col = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // row
                    matrix[0][j] = 0; // col
                }
            }
        }

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
    /* Start of Maximum subarray - BRUTE */
    public void maximumSubarray() {
        int n = 5;
        int[] arr = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + "");
            for (int j = i + 1; j < n; j++) {
                System.out.println(arr[j] + "");
            }
            System.out.println("-------------");
        }
    }

    public static void main(String[] args) {
        Day_1 p1 = new Day_1();
        p1.maximumSubarray();
    }
}
