import java.util.*;

class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        // Build graph: node -> (neighbor, cost)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            
            int cost = cnt + 1; // total cost to go from u to v
            graph.get(u).add(new int[]{v, cost});
            graph.get(v).add(new int[]{u, cost});
        }
        
        // Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0}); // node, distance
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
            
            if (d > dist[node]) continue;
            
            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int cost = neighbor[1];
                
                if (d + cost < dist[next]) {
                    dist[next] = d + cost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        int result = 0;
        
        // Count reachable original nodes
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) {
                result++;
            }
        }
        
        // Count reachable subdivided nodes
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            
            int fromU = dist[u] > maxMoves ? 0 : maxMoves - dist[u];
            int fromV = dist[v] > maxMoves ? 0 : maxMoves - dist[v];
            
            result += Math.min(cnt, fromU + fromV);
        }
        
        return result;
    }
}