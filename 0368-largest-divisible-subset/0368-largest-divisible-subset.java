class Solution {
       public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        List<Integer> ans = new ArrayList<>(); 
        
        int[] dp = new int[n]; 
        Arrays.fill(dp, 1);
        
        int[] parent = new int[n]; 
        int lastIndex = 0; 
        int maxLen = 0;
        
        for(int i = 0; i < n; i++) {
            parent[i] = i; // Assign the parent to itself
            
            // For each previous index
            for(int prevInd = 0; prevInd < i; prevInd++) {
                
                // If the element at index i can be included in the LDS ending at index j
                if(nums[i] % nums[prevInd] == 0 && dp[i] < dp[prevInd] + 1) {
                    dp[i] = dp[prevInd] + 1; // Update the DP value
                    parent[i] = prevInd; // Store the parent
                }
            }
            // If a longer LDS is found, update the values
            if(dp[i] > maxLen) {
                lastIndex = i;
                maxLen = dp[i];
            }
        }
        // Backtracking
        int i = lastIndex;
        
        // Until we reach an index which is its own parent
        while(parent[i] != i) {
            ans.add(nums[i]); // Add the element at current index
            i = parent[i]; 
        }
        ans.add(nums[i]); // Adding the last element 
        
        // Return the computed result
        return ans;
      
    }
}