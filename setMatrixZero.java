//Brute Force Approach
//Time complexity  = O(N^3) (Assuming M == N)
//Space Complexity = O(N^2)


class Solution {

    public void markRow(int[][] matrix, int row, int num) {
        int noOfCols = matrix[0].length;
        for (int i = 0; i < noOfCols; i++) {
            matrix[row][i] = num;
        }
    }

    public void markCol(int[][] matrix, int col, int num) {
        int noOfRows = matrix.length; // Use .length instead of .size()
        for (int i = 0; i < noOfRows; i++) {
            matrix[i][col] = num;
        }
    }

    public void setZeroes(int[][] matrix) {
        // Matrix dimensions
        int m = matrix.length; // Use .length instead of .size()
        int n = matrix[0].length; // Use .length instead of .size()
        // Make a copy of matrix
        int[][] matCopy = new int[m][n];
        for(int i = 0; i < m; i++) {
            matCopy[i] = Arrays.copyOf(matrix[i], n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matCopy[i][j] == 0) {
                    markRow(matrix, i, 0);
                    markCol(matrix, j, 0);
                }
            }
        }
    }
}





//Better Approach: Using Extra Space 
//Time complexity = O(N*M + N*M)
//Space complexity = O(N + M)


class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}



//Most optimal approach
//Space Complexity = O(1)
//Time Complpexity = O(M*N)

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean markColZero = false;

        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length;


        //Marks rows and columns.
        for(int rowNo = 0; rowNo < noOfRows; rowNo++) {
            for(int colNo = 0; colNo < noOfCols; colNo++) {
                if(matrix[rowNo][colNo] == 0) {
                    if(colNo == 0) {
                        //Mark col 0th status.
                        markColZero = true;
                    }
                    else {
                        //Mark col status for the rest of the columns.
                        matrix[0][colNo] = 0;
                    }
                    //Mark row status.
                    matrix[rowNo][0] = 0;
                } else continue;
            }
        }

        for(int rowNo = noOfRows - 1; rowNo >= 0; rowNo--) {
            for(int colNo = noOfCols - 1; colNo >= 0; colNo--) {
                if(colNo == 0 && markColZero) {
                    matrix[rowNo][colNo] = 0;
                }
                else if((matrix[rowNo][0] == 0 || matrix[0][colNo] == 0) && colNo != 0) {
                    matrix[rowNo][colNo] = 0;
                }
            }
        }
        
    }
}
