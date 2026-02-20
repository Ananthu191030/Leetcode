class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        int maxi=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]==1){
                    maxi=Math.max(maxi,dfs(i,j,m,n,grid,vis));
                    // maxi=Math.max(cou,maxi);
                    // dfs(i,j,m,n,grid,vis);
                }
            }
        }
        return maxi;
    }
    public int dfs(int r, int c,int m,int n,int grid[][],boolean vis[][]){
        vis[r][c]=true;
        int count=1;
        int delR[]={-1,0,1,0};
        int delC[]={0,-1,0,1};
        for(int ind=0;ind<4;ind++){
            int newr=r+delR[ind];
            int newc=c+delC[ind];
            if(newr>=0&&newr<m&&newc>=0&&newc<n&&!vis[newr][newc]&&grid[newr][newc]==1){
                    count+=dfs(newr,newc,m,n,grid,vis);
            }
        }
        return count;
    }
}