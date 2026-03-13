class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;

        if (Math.abs(target) > total) return 0;

        int[][] dp = new int[n][2 * total + 1];
        for (int[] row : dp) Arrays.fill(row, -1);  // ✅ -1 as sentinel

        return f(n - 1, target, nums, total, dp);
    }

    public int f(int ind, int tar, int[] nums, int total, int[][] dp) {
        if (ind == 0) {
            int count = 0;
            if (tar == nums[0]) count++;
            if (tar == -nums[0]) count++;
            return count;
        }
        if (tar > total || tar < -total) return 0;

        if (dp[ind][tar + total] != -1)  // ✅ check -1
            return dp[ind][tar + total];

        int add      = f(ind - 1, tar - nums[ind], nums, total, dp);
        int subtract = f(ind - 1, tar + nums[ind], nums, total, dp);

        return dp[ind][tar + total] = add + subtract;
    }
}