class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int c = 0; c < cols; c++) 
        {
            int maxVal = -1;

            for (int r = 0; r < rows; r++) 
            {
                if (matrix[r][c] > maxVal) 
                {
                    maxVal = matrix[r][c];
                }
            }
            for (int r = 0; r < rows; r++) 
            {
                if (matrix[r][c] == -1) 
                {
                    matrix[r][c] = maxVal;
                }
            }
        }

        return matrix;
    }
}
