class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // The transposed matrix has swapped dimensions: cols x rows
        int[][] transposed = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                transposed[c][r] = matrix[r][c];
            }
        }

        return transposed;
    }
}