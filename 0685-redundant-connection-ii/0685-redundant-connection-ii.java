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
    public int findpar(int node)
    {
        if(node==par[node]) return node;
        return par[node]=findpar(par[node]);
    }
    public boolean uni(int u,int v){
        int uu=findpar(u);
        int uv=findpar(v);
        if(uu==uv) return false;
        if(rank[uu]>rank[uv]) par[uv]=uu;
        else if(rank[uv]>rank[uu]) par[uu]=uv;
        else {
            par[uv]=uu;
            rank[uu]++;
        }
        return true;
    }
}


class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        int par[]=new int[n+1];
        int[] edge1=null,edge2=null;
        for(int[] ed:edges){
            int u=ed[0],v=ed[1];
            if(par[v]==0){
                par[v]=u;
            }
            else{
                edge1=new int[]{par[v],v};
                edge2=new int[]{u,v};
                ed[1]=0;
            }
        }
        Disjoint ds=new Disjoint(n);
        for(int ed[]:edges){
            if(ed[1]==0) continue;
        if(!ds.uni(ed[0],ed[1]))
        {
            if(edge1==null) return ed;
            return edge1;
        }
        }
        return edge2;
    }
}