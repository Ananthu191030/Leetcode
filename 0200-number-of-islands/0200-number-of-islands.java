class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    if(!vis[i][j]&&grid[i][j]=='1'){
                    count++;
                    dfs(vis,i,j,n,m,grid);
                    }
            }
        }
        return count;
    }
    public void dfs(boolean vis[][],int row,int col,int n,int m,char grid[][]){
        vis[row][col]=true;
        int delR[]={-1,0,1,0};
        int delC[]={0,-1,0,1};
        for(int ind=0;ind<4;ind++){
            int newR=row+delR[ind];
            int newC=col+delC[ind];
                if(newR<n&&newR>=0&&newC>=0&&newC<m&&grid[newR][newC]=='1'&&!vis[newR][newC]){
                   dfs(vis,newR,newC,n,m,grid);

                }
            }
            }
}