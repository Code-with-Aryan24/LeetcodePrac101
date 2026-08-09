class Solution {
    private int[] suffixSum;
    private int[][] dp;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // suffixSum[i] stores the sum of piles from index i to the end
        suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        // dp[i][M] stores max stones current player can get from index i with given M
        // M can be at most n, so we size it [n+1][n+1] to avoid index out of bounds
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int m = 0; m <= n; m++) {
                dp[i][m] = -1;
            }
        }
        
        return helper(0, 1, n);
    }

    private int helper(int i, int M, int n) {
        // If we can take all remaining piles, take them
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }
        
        // Return memoized result if already computed
        if (dp[i][M] != -1) {
            return dp[i][M];
        }
        
        int bestScore = 0;
        
        // Try taking X piles, where 1 <= X <= 2 * M
        for (int X = 1; X <= 2 * M; X++) {
            // Stones taken now = suffixSum[i] - suffixSum[i + X]
            // Stones taken later = suffixSum[i + X] - opponent's best score
            int stonesTakenNow = suffixSum[i] - suffixSum[i + X];
            int nextM = Math.max(M, X);
            int opponentBestScore = helper(i + X, nextM, n);
            
            int totalScore = stonesTakenNow + (suffixSum[i + X] - opponentBestScore);
            bestScore = Math.max(bestScore, totalScore);
        }
        
        dp[i][M] = bestScore;
        return bestScore;
    }
}