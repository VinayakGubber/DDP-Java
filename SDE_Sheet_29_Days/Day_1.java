package SDE_Sheet_29_Days;

public class Day_1 {
    /* Start of Set Matrix Zero - BRUTE */

    /* B R U T E */
    /*
     * Fails in case of matrix containing negative numbers
     * 
     * Time complexit is O(MxN)+O(M+N)+O(MxN)
     */
    public void setMatrixZero(int[][] matrix) {
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

    public void setZeroes(int[][] matrix) {
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

    public void set0(int[][] matrix, int[] arrRow, int[] arrCol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (arrRow[i] == 1 || arrCol[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /* End of Set Matrix Zero - B E T T E R */
}
