class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];
        int mod = (int)(1e9 + 7);

        PriorityQueue<long[]> pq =
            new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0L, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long dis = curr[0];
            int node = (int) curr[1];

            if (dis > dist[node]) continue;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int weight = neighbor[1];

                if (dis + weight < dist[adjNode]) {
                    dist[adjNode] = dis + weight;
                    pq.add(new long[]{dist[adjNode], adjNode});
                    ways[adjNode] = ways[node];
                } 
                else if (dis + weight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}
