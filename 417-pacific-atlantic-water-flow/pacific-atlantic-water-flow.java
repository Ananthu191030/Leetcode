class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Pacific borders
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, n - 1, atlantic, heights);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights);
            dfs(m - 1, j, atlantic, heights);
        }

        // Collect cells reachable by both
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        visited[r][c] = true;
        int[] delR = {-1, 0, 1, 0};
        int[] delC = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int newR = r + delR[i];
            int newC = c + delC[i];

            if (newR >= 0 && newC >= 0 &&
                newR < heights.length && newC < heights[0].length &&
                !visited[newR][newC] &&
                heights[newR][newC] >= heights[r][c]) {

                dfs(newR, newC, visited, heights);
            }
        }
    }
}
