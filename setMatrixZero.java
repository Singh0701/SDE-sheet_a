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

