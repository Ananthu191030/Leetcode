class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[n];
        q.add(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            if(node==destination) return true;
            for(int nei:graph.get(node)){
                if(!visited[nei]){
                    visited[nei]=true;
                    q.add(nei);
                }
            }
        }
        return false;
    }
}