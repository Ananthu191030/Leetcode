class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int n : nums) maxVal = Math.max(maxVal, n);
        int[] points = new int[maxVal + 1];
        for (int n : nums) points[n] += n;  
        int[] dp = new int[maxVal + 1];
        Arrays.fill(dp, -1);
        return fun(points, maxVal, dp);
    }

    int fun(int[] points, int n, int[] dp) {
        if (n == 0) return points[0];
        if (n < 0)  return 0;
        if (dp[n] != -1) return dp[n];
        int take    = points[n] + fun(points, n-2, dp);
        int nontake = fun(points, n-1, dp);
        return dp[n] = Math.max(take, nontake);
    }
}