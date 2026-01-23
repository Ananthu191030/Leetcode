class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int count = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) total++;
                if (grid[i][j] == 2) {
                    rotten.add(new int[]{i, j});
                }
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int days = 0;
        while (!rotten.isEmpty()) {
            int k = rotten.size();
            count += k;
            for (int i = 0; i < k; i++) {
                int[] pos = rotten.poll();
                int x = pos[0], y = pos[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1)
                        continue;
                    grid[nx][ny] = 2;
                    rotten.add(new int[]{nx, ny});
                }
            }
            if (!rotten.isEmpty()) days++;
        }
        return total == count ? days : -1;
    }
}