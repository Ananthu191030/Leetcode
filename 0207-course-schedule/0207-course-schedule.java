class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adj=new ArrayList<>();
            for(int i=0;i<numCourses;i++){
                adj.add(new ArrayList<>());
            }
            int ind[]=new int[numCourses];
            Queue<Integer> q=new LinkedList<>();
            for(int pre[]:prerequisites){
                adj.get(pre[1]).add(pre[0]);
                ind[pre[0]]++;
            }
            for(int i=0;i<numCourses;i++){
                if(ind[i]==0)
                q.offer(i);
            }
            int c=0;
            while(!q.isEmpty()){
                 int node=q.poll();
                 c++;
                 for(int nei:adj.get(node)){
                    ind[nei]--;
                    if(ind[nei]==0)
                    q.offer(nei);
                 }
            }
            return c==numCourses;
    }
}