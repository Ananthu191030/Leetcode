class Solution {

    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;
    }
}
