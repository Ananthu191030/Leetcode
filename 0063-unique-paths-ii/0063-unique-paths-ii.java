class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int up,l;
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        if(grid[m-1][n-1]==1) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                up=0;
                l=0;
                if(i==0&&j==0) dp[0][0]=1;
                else{if(i>0){
                    if(grid[i-1][j]!=1) up=dp[i-1][j];
                }
                if(j>0){
                    if(grid[i][j-1]!=1) l=dp[i][j-1];
                }
                dp[i][j]=up+l;
            }
            }
        }
        return dp[m-1][n-1];
    }
}