class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            ans[i] = Arrays.copyOf(image[i], image[i].length);
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, color, delRow, delCol, iniColor);
        return ans;
    }
    public void dfs(int sr,int sc,int ans[][],int image[][],int newc,int delr[],int delc[],int ini){
        int n=image.length;
        int m=image[0].length;
        ans[sr][sc]=newc;
        for(int i=0;i<4;i++){
            int row=sr+delr[i];
            int col=sc+delc[i];
            if(row<n&&row>=0&&col<m&&col>=0&&ans[row][col]==ini&&ans[row][col]!=newc)
            dfs(row,col,ans,image,newc,delr,delc,ini);
        }
    }
}