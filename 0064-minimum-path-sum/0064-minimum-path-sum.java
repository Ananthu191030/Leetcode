class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        int r,d;
        int mini;
        dp[0][0]=grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                r=Integer.MAX_VALUE;
                d=Integer.MAX_VALUE;
                if(i==0&&j==0) continue;
               if(i>0) r=dp[i-1][j]; 
               if(j>0) d=dp[i][j-1];
               dp[i][j]=grid[i][j]+Math.min(r,d); 
            }
        }
        return dp[m-1][n-1];
    }
}