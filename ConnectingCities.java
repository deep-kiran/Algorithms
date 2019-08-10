class ConnectingCities {
    
    int n;
    int parent[];
    //Add edges in increasing weight, skipping those whose addition would create a cycle
    private void union(int x, int y){
        int fx =find(x);
        int fy =find(y);
        if(fx!=fy){
            n--;
            parent[fx] =fy;
        }
    }
    private int find(int x){
        if(parent[x]==x){
            return parent[x];
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
    public int minimumCost(int N, int[][] connections) {
        n =N;
        parent =new int[N+1];
        Arrays.sort(connections,(a,b)->a[2]-b[2]);
        for(int i=0;i<=N;i++){
            parent[i]=i;
        }
        int res =0;
        for(int connect[]:connections){
            int x =connect[0];
            int y =connect[1];
            if(find(x)!=find(y)){
                res += connect[2];
                union(x,y);
            }
                   
            
        }
        return (n==1)? res: -1;
    }
}
