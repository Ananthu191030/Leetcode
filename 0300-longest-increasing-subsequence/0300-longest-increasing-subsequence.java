class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0,-1,n,nums,dp);
    }
    public int f(int ind,int prev_ind,int n,int nums[],int dp[][]){
        if(ind==n) return 0;
        if(dp[ind][prev_ind+1]!=-1) return dp[ind][prev_ind+1];
        int len=0+f(ind+1,prev_ind,n,nums,dp);
        if(prev_ind==-1||nums[ind]>nums[prev_ind])
        len=Math.max(len,1+f(ind+1,ind,n,nums,dp));
        return dp[ind][prev_ind+1]=len;

    }
}