class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) newNums[i + 1] = nums[i];

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(1, n, newNums, dp);
    }
    int f(int l, int r, int[] nums, int[][] dp) {
        if (l > r) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        int maxi = 0;
        for (int last = l; last <= r; last++) {
            int coin = nums[l - 1] * nums[last] * nums[r + 1]  
                     + f(l, last - 1, nums, dp)                 
                     + f(last + 1, r, nums, dp);                
            maxi = Math.max(maxi, coin);
        }

        return dp[l][r] = maxi;
    }
}
