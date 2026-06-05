class Solution {
    public void rotate(int[][] matrix) {
        final int n = matrix.length;

        if (n == 1) {
            return;
        }

        // reverse vertically
        int i = 0, row = 0, col = 0; 
        while (i < (n / 2) * n) {
            row = i / n;
            col = i % n; 

            int temp = matrix[row][col];
            matrix[row][col] = matrix[n-1-row][col];
            matrix[n-1-row][col] = temp;

            i++;
        }

        // reverse over main diagonal (/)    
        // essentially clockwise rotation of each row
        // just swap row & col: old(row, col) => new(col, row)
        for (row = 0; row < n - 1; row++) {
            for (col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // arrays are passed by reference so no need to return it
        // assuming we did the rotation in-place
    }
}