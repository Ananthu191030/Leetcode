class Solution {
    public int lengthOfLIS(int[] nums) {
         int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) 
                temp.add(nums[i]); 
            else {
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                temp.set(ind, nums[i]);
            }    
        }
        return temp.size();
    }
}