class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int tar=sum/2;
        int n=nums.length;
        boolean dp[][]=new boolean[n][tar+1];
        if(sum%2!=0) return false;
        for(int i=0;i<n;i++){
            dp[i][0]=true;}
            if (nums[0] <= tar) 
            dp[0][nums[0]]=true;
            for(int i=1;i<n;i++){
                for(int t=1;t<=tar;t++){
                    boolean nontake=dp[i-1][t];
                    boolean take=false;
                    if(nums[i]<=t){
                        take=dp[i-1][t-nums[i]];
                    }
                    dp[i][t]=take||nontake;
                }
            }
    return dp[n-1][tar];
    }
}
