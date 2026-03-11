class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = f(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int f(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -1) return dp[amount];
        int mini = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = f(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE)
                mini = Math.min(mini, 1 + res);
        }

        return dp[amount] = mini;
    }
}