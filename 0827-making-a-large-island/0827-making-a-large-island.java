class DisjointSet{
    int[] rank,size,par;
    DisjointSet(int n){
        rank=new int[n+1];
        par=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<n;i++)
        {
            par[i]=i;
            size[i]=1;
    }
    }
    int findPar(int node){
        if(par[node]==node)
        return node;
        return par[node]=findPar(par[node]);
    }
    void unionBySize(int u,int v){
        int upu=findPar(u);
        int upv=findPar(v);
        if(upu==upv) return;
        if(size[upu]<size[upv]){
            par[upu]=upv;
            size[upv]+=size[upu];
        }
        else{
            par[upv]=upu;
            size[upu]+=size[upv];
        }
    }
}
class Solution {
    int[] delR={-1,0,1,0};
    int[] delC={0,1,0,-1};
    public boolean valid(int i,int j,int n){
        if(i<0||i>=n) return false;
        if(j<0||j>=n) return false;
        return true;
    }
    public void addIniIsland(int[][] grid,DisjointSet ds,int n
    ){
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==0) continue;
                for(int ind=0;ind<4;ind++){
                    int newR=delR[ind]+r;
                    int newC=delC[ind]+c;
                    if(valid(newR,newC,n)&& grid[newR][newC]==1){
                        int nodenum=r*n+c;
                        int adjnum=newR*n+newC;
                        ds.unionBySize(nodenum,adjnum);
                    }
                    }
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        addIniIsland(grid,ds,n);
        int ans=0;
        for(int r=0;r<n;r++){
        for(int c=0;c<n;c++){
            if(grid[r][c]==1) continue;
            Set<Integer> s=new HashSet<>();
            for(int ind=0;ind<4;ind++){
                int newR=r+delR[ind];
                int newC=c+delC[ind];
                if(valid(newR,newC,n)&&grid[newR][newC]==1){
                    int noden=newR*n+newC;
                    s.add(ds.findPar(noden));
                }
            }
            int tot=0;
            for(int pa:s){
                tot+=ds.size[ds.findPar(pa)];
            }
            ans=Math.max(ans,tot+1);
        }
        }
         for (int cellNo = 0; cellNo < n * n; cellNo++) {
            ans = Math.max(ans, ds.size[ds.findPar(cellNo)]);
        }
        return ans;
    }
}
