class Solution {
    public int minimumEffortPath(int[][] heights) {
         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
         int n = heights.length;  // Number of rows
        int m = heights[0].length;  // Number of columns
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;  // Distance for the source cell (0, 0) is 0
        pq.add(new int[]{0, 0, 0});  // Push source cell to the priority queue
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int diff = current[0];  
            int row = current[1];
            int col = current[2];
            if (row == n - 1 && col == m - 1)
                return diff;
            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];
                if (newr >= 0 && newc >= 0 && newr < n && newc < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);
                    if (newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        pq.add(new int[]{newEffort, newr, newc});
                    }
                }
            }
        }
        return 0; 
    }
}