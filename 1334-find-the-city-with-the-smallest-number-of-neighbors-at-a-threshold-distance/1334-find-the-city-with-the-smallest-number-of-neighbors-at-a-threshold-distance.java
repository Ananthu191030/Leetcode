class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        // Set the distance for each edge
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];  // Set the distance from city1 to city2
            dist[edge[1]][edge[0]] = edge[2];  // Set the distance from city2 to city1
        }

        // Set the diagonal to 0, as the distance from a city to itself is 0
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Apply Floyd-Warshall Algorithm to find the shortest paths between all pairs of cities
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Initialize variables to track the city with the least reachable cities
        int cntCity = n;
        int cityNo = -1;

        // Check each city and count the number of cities within the threshold distance
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold) {
                    cnt++;
                }
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}