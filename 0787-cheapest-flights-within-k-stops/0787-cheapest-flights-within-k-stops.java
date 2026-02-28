class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int fli[]:flights){
            adj.get(fli[0]).add(new int[]{fli[1],fli[2]});
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,src,0});
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        while(!q.isEmpty()){
            int c[]=q.poll();
            int stops=c[0];
            int node=c[1];
            int cost=c[2];
            if(stops>k) continue;
            for(int[] nei:adj.get(node)){
                int next=nei[0];
                int cos=nei[1];
                if(dist[next]>cost+cos && stops<=k)
                {
                    dist[next]=cost+cos;
                    q.offer(new int[]{stops+1,next,cost+cos});
                }
            }
        }
      
            if(dist[dst]==Integer.MAX_VALUE) return -1;
            return dist[dst];
    }
}