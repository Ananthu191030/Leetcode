class Solution{
 public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, Integer.MIN_VALUE);
        return dfs(0, 0, m, n, coins, 0, dp);
    }
    int dfs(int r, int c, int m, int n, int[][] coins, int k, int[][][] dp) {
        if (r == m-1 && c == n-1) {
            if (coins[r][c] < 0 && k < 2)
                return 0; 
            return coins[r][c];
        }

        if (r >= m || c >= n) return Integer.MIN_VALUE;

        if (dp[r][c][k] != Integer.MIN_VALUE) return dp[r][c][k];
        int down  = dfs(r+1, c, m, n, coins, k, dp);
        int right = dfs(r, c+1, m, n, coins, k, dp);
        int best  = coins[r][c] + Math.max(
                        down  == Integer.MIN_VALUE ? Integer.MIN_VALUE : down,
                        right == Integer.MIN_VALUE ? Integer.MIN_VALUE : right
                    );

        if (coins[r][c] < 0 && k < 2) {
            int down2  = dfs(r+1, c, m, n, coins, k+1, dp);
            int right2 = dfs(r, c+1, m, n, coins, k+1, dp);
            int skip   = Math.max(
                            down2  == Integer.MIN_VALUE ? Integer.MIN_VALUE : down2,
                            right2 == Integer.MIN_VALUE ? Integer.MIN_VALUE : right2
                         );
            best = Math.max(best, skip);
        }

        return dp[r][c][k] = best;
    }
}
