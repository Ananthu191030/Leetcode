class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] fli:flights){
            adj.get(fli[0]).add(new int[]{fli[1],fli[2]});
        }
        System.out.println(adj);
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,src,0});
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int stops=curr[0];
            int node=curr[1];
            int cost=curr[2];
            if(stops>k) continue;
            for(int[] adjNode:adj.get(node)){
                int nextn=adjNode[0];
                int cos=adjNode[1];
                if(cost+cos<dist[nextn]&&stops<=k){
                    dist[nextn]=cost+cos;
                    q.offer(new int[]{stops+1,nextn,cost+cos});
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
        return -1;
        return dist[dst];
    }
}