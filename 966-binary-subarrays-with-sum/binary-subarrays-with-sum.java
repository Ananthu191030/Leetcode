class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return fun(nums,goal)-fun(nums,goal-1);
    }
        public int fun(int nums[],int goal){
        int l=0,r=0,sum=0,maxlen=0;
        int len=nums.length;
        if(goal<0) return 0;
        while(r<len){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            maxlen+=r-l+1;
            r++;
        }
        return maxlen;
    }
}