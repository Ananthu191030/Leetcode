class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int inDeg[]=new int[numCourses];
        for(int pre[]:prerequisites){
            int a=pre[0];
            int b=pre[1];
            adj.get(b).add(a);
            inDeg[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDeg[i]==0) q.offer(i);
        }
        int order[]=new int[numCourses];
        int ind=0;
        while(!q.isEmpty()){
            int node=q.poll();
            order[ind++]=node;
            for(int nei:adj.get(node)){
                inDeg[nei]--;
                if(inDeg[nei]==0) q.offer(nei);
            }
        }
        if(ind==numCourses) return order;
        return new int[0];
    }
}