import java.util.*;

class DisjointSet {
    int[] parent, rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int findPar(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = findPar(parent[node]); // path compression
    }

    void unionByRank(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);

        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int total = n * n;

        DisjointSet ds = new DisjointSet(total);

        // store cells as (height, row, col)
        List<int[]> cells = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{grid[i][j], i, j});
            }
        }

        // sort by height
        Collections.sort(cells, (a, b) -> a[0] - b[0]);

        boolean[][] visited = new boolean[n][n];
        int[] delR = {-1, 0, 1, 0};
        int[] delC = {0, 1, 0, -1};

        for (int[] cell : cells) {
            int height = cell[0];
            int r = cell[1];
            int c = cell[2];

            visited[r][c] = true;
            int node = r * n + c;

            for (int k = 0; k < 4; k++) {
                int nr = r + delR[k];
                int nc = c + delC[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && visited[nr][nc]) {
                    int adjNode = nr * n + nc;
                    ds.unionByRank(node, adjNode);
                }
            }

            // check if start and end are connected
            if (ds.findPar(0) == ds.findPar(total - 1)) {
                return height;
            }
        }

        return -1;
    }
}