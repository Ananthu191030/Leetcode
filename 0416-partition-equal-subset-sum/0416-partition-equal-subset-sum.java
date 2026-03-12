class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Odd sum can never be split equally
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(n - 1, target, nums, dp);
    }

    // Can we reach exactly 'target' sum using elements 0..ind?
    boolean f(int ind, int target, int[] nums, int[][] dp) {
        // Found a subset with exactly target sum
        if (target == 0) return true;

        // Ran out of elements
        if (ind == 0) return nums[0] == target;

        if (dp[ind][target] != -1) return dp[ind][target] == 1;

        // Option 1: skip current element
        boolean notTake = f(ind - 1, target, nums, dp);

        // Option 2: take current element (only if it doesn't exceed target)
        boolean take = false;
        if (nums[ind] <= target)
            take = f(ind - 1, target - nums[ind], nums, dp);

        boolean result = take || notTake;
        dp[ind][target] = result ? 1 : 0;
        return result;
    }
}
