class Solution {
    public char[][] solve(char[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
         if (n == 0 || m == 0) return mat;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[][] vis = new int[n][m];
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && mat[0][j] == 'O') dfs(0, j, vis, mat, dr, dc);
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') dfs(n - 1, j, vis, mat, dr, dc);
        }
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && mat[i][0] == 'O') dfs(i, 0, vis, mat, dr, dc);
            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') dfs(i, m - 1, vis, mat, dr, dc);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') mat[i][j] = 'X';
            }
        }
        return mat;
    }
        private void dfs(int r, int c, int[][] vis, char[][] mat, int[] dr, int[] dc) {
        vis[r][c] = 1;
        int n = mat.length, m = mat[0].length;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k], nc = c + dc[k];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && mat[nr][nc] == 'O') {
                dfs(nr, nc, vis, mat, dr, dc);
            }
        }
    }
    
}