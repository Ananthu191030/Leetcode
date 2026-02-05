class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V=adj.length;
        List<Integer>[] adjRev = new List[V]; 
        int[] indegree = new int[V]; 
        for (int i = 0; i < V; i++) {
            adjRev[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj[i]) {
                adjRev[neighbor].add(i); 
                indegree[i]++;  
            }
        }

        Queue<Integer> q = new LinkedList<>();  
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);  
            for (int parent : adjRev[node]) {
                indegree[parent]--;  
                if (indegree[parent] == 0) {
                    q.offer(parent);  
                }
            }
        }

        Collections.sort(safeNodes);  
        return safeNodes;
    }
    }
