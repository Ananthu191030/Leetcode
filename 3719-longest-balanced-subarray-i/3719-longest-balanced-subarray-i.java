import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            
            for (int j = i; j < n; j++) {
                
                if (nums[j] % 2 == 0) {
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }
                
                if (even.size() == odd.size()) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        
        return maxLength;
    }
}
