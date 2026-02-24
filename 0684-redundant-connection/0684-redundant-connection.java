class Disjoint{
        int par[];
        int rank[];
        Disjoint(int n){
            par=new int[n+1];
            rank=new int[n+1];
            for(int i=0;i<=n;i++){
                par[i]=i;
            }
        }
        public int findpar(int node){
            if(node==par[node])
            return par[node];
            return par[node]=findpar(par[node]);
        }
        public boolean uni(int u,int v){
            int uu=findpar(u);
            int uv=findpar(v);
            if(uu==uv) return false;
            if(rank[uu]>rank[uv]) par[uv]=uu;
            else if(rank[uv]>rank[uu]) par[uu]=uv;
            else{
                par[uu]=uv;
                rank[uv]++;
            }
            return true;
        } 
}
class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Disjoint ds=new Disjoint(n);
        for(int[] ed:edges){
        if(!ds.uni(ed[0],ed[1]))
            return ed;
    }
    return new int[0];
    }
}