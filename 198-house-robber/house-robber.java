class Solution {
    public int rob(int[] nums) {
        int maxi=0,n;
        n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int notake=dp[i-1];
            int take=nums[i];
            if(i>1){
             take+=dp[i-2];
            }
            dp[i]=Math.max(take,notake);
        }

        return dp[n-1];
    }
    // int f(int n,int nums[],int maxi){
    //     if(n==0) return nums[0];
    //     if(n<0) return 0;
    //     int take=nums[n]+f(n-2,nums,maxi);
    //     int notake=0+f(n-1,nums,maxi);
    //     maxi=Math.max(take,notake);
    //     return maxi;
    // }
}