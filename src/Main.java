public class Main {
    public static void main(String[] args) {

        int[][] matrix = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };

        SetMatrixZero obj = new SetMatrixZero();
        obj.setZeroes(matrix);
        obj.print(matrix);
    }
}

/*
        Optimal Solution:

        Time Complexity : O(n * m)
        Space Complexity: O(1)
 */

class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowHaveZero = false;
        boolean isColumnRowHaveZero = false;

        // ** Finding Zero **
        // Check if the first row contains zero
        for(int iterator = 0; iterator < matrix[0].length; iterator++) {
            if(matrix[0][iterator] == 0) {
                isFirstRowHaveZero = true;
                break;
            }
        }

        // Check if the first column contains zero
        for(int jterator = 0; jterator < matrix.length; jterator++) {
            if(matrix[jterator][0] == 0) {
                isColumnRowHaveZero = true;
                break;
            }
        }

        // Use first row and first column as markers
        for(int iterator = 1; iterator < matrix.length; iterator++) {
            for(int jterator = 1; jterator < matrix[0].length; jterator++) {
                if(matrix[iterator][jterator] == 0) {
                    matrix[iterator][0] = 0;
                    matrix[0][jterator] = 0;
                }
            }
        }

        // ** Setting Zero **
        // Set the zeroes based on markers in the first row
        for(int iterator = 1; iterator < matrix[0].length; iterator++) {
            if(matrix[0][iterator] == 0) {
                  setZeroForWholeColumn(iterator, matrix );
            }
        }

        // Set the zeroes based on markers in the first column
        for(int iterator = 1; iterator < matrix.length; iterator++) {
            if(matrix[iterator][0] == 0) {
                setZeroForWholeRow(iterator, matrix);
            }
        }

        // Zero the first row if needed
        if(isFirstRowHaveZero) {
            for(int iterator = 0; iterator < matrix[0].length; iterator++) {
                matrix[0][iterator] = 0;
            }
        }

        // Zero the first column if needed
        if(isColumnRowHaveZero) {
            for(int iterator = 0; iterator < matrix.length; iterator++) {
                matrix[iterator][0] = 0;
            }
        }

    }


    // Set the entire column to zero
    public static void setZeroForWholeColumn(int indexOfColumn, int[][] matrix) {

        for(int iterator = 0; iterator < matrix.length; iterator++) {
            matrix[iterator][indexOfColumn] = 0;
        }
    }

    // Set the entire row to zero
    private void setZeroForWholeRow(int indexOfColumn, int[][] matrix) {
        for(int jterator = 0; jterator < matrix[0].length; jterator++) {
            matrix[indexOfColumn][jterator] = 0;
        }
    }

    // ** print the matrix **
    public void print(int[][] matrix) {
        for(int iterator = 0; iterator < matrix.length; iterator++) {
            for (int jterator = 0; jterator < matrix[0].length; jterator++) {
                System.out.print(matrix[iterator][jterator]);
            }
            System.out.println();
        }
    }
}