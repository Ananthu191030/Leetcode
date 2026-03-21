class Solution {
    public int change(int a, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][a+1];
         for(int i=0;i<=a;i++) {
            if(i%coins[0]==0)
            dp[0][i]=1;
            else
            dp[0][i]=0;
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=a;t++){
                int nontake=dp[i-1][t];
        int take=0;
        if(t>=coins[i])
        take=dp[i][t-coins[i]];
        dp[i][t]=take+nontake;
            }
        }
        return  dp[n-1][a];
   
    }
}