class Solution {
    public int countAtMost(int[] nums, int k) {
        int left = 0, res = 0;

        // Traverse through the array
        for (int right = 0; right < nums.length; right++) {
            // If current number is odd, reduce k
            if (nums[right] % 2 != 0)
                k--;

            // Shrink the window until k is valid
            while (k < 0) {
                if (nums[left] % 2 != 0)
                    k++;
                left++;
            }

            // Add valid subarrays ending at right
            res += (right - left + 1);
        }

        // Return result
        return res;
    }

    // Function to return number of subarrays with exactly k odd numbers
    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }
}
