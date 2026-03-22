class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];
         int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);
         return f(1, n, arr, dp);
    }
    int f(int l, int r, int[] arr, int[][] dp) {
        if (l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];
        int maxi = 0;
        for (int last = l; last <= r; last++) {
            int coins = arr[l-1] * arr[last] * arr[r+1] 
                      + f(l, last-1, arr, dp)             
                      + f(last+1, r, arr, dp);           
            maxi = Math.max(maxi, coins);
        }
        return dp[l][r] = maxi;
    }
}
