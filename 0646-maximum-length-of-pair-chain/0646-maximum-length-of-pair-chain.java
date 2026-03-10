class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(0, -1, n, pairs, dp);
    }

    public int f(int ind, int prev_ind, int n, int[][] pairs, int[][] dp) {
        if (ind == n) return 0;
        if (dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1];
        int len = f(ind + 1, prev_ind, n, pairs, dp);
        if (prev_ind == -1 || pairs[ind][0] > pairs[prev_ind][1])
            len = Math.max(len, 1 + f(ind + 1, ind, n, pairs, dp));
        return dp[ind][prev_ind + 1] = len;
    }
}