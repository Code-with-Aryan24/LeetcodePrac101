class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                
                if (matrix[i][j] == '1') 
                {
                    
                    if (i == 0 || j == 0) 
                    {
                        dp[i][j] = 1;
                    } else 
                    {
                        
                        int top = dp[i - 1][j];
                        int left = dp[i][j - 1];
                        int diag = dp[i - 1][j - 1];

                        dp[i][j] = 1 + Math.min(top, Math.min(left, diag));
                    }
                    
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}