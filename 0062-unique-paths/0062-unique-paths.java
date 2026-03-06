class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        int up,d;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) dp[i][j]=1;
                else{
                    up=0;
                    d=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) d=dp[i][j-1];
                    dp[i][j]=up+d;
                }
            }
        }
        return dp[m-1][n-1];
    }
}