class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int vis[][]=new int[m][n];
        int dist[][]=new int[m][n];
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=1;
                }
                else vis[i][j]=0;
            }
        }
        int delr[]={-1,0,1,0};
        int delc[]={0,1,0,-1};
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int r=cell[0];
            int c=cell[1];
            int steps=cell[2];
            dist[r][c]=steps;
            for(int i=0;i<4;i++){
                int newr=r+delr[i];
                int newc=c+delc[i];
                if(newr>=0&&newr<m&&newc>=0&&newc<n&&vis[newr][newc]==0){
                    vis[newr][newc]=1;
                    q.add(new int[]{newr,newc,steps+1});
                }
            }
        }
        return dist;
    
}
}