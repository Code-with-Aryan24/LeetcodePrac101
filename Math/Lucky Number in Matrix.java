import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] rowMins = new int[rows];
        int[] colMaxs = new int[cols];

        
        Arrays.fill(rowMins, Integer.MAX_VALUE);
        Arrays.fill(colMaxs, Integer.MIN_VALUE);

        
        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) {
                rowMins[r] = Math.min(rowMins[r], matrix[r][c]);
                colMaxs[c] = Math.max(colMaxs[c], matrix[r][c]);
            }
        }

        
        List<Integer> lucky = new ArrayList<>();
        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) 
            {
                if (matrix[r][c] == rowMins[r] && matrix[r][c] == colMaxs[c]) 
                {
                    lucky.add(matrix[r][c]);
                }
            }
        }

        return lucky;
    }
}