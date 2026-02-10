class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int nei[]:times){
             adj.get(nei[0]).add(new int[]{nei[1],nei[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,k});
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int node=curr[1];
            int wt=curr[0];
            for(int ne[]:adj.get(node)){
                int v=ne[0], wei=ne[1];
                if(dist[v]>wt+wei){
                    dist[v]=wt+wei;
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}