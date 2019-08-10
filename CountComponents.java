class CountComponents {
    public int countComponents(int n, int[][] edges) {
     int []parent =new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int []edge :edges){
          int p1 =find(parent,edge[0]);
          int p2 =find(parent,edge[1]);
          if(p1 !=p2){ //are in disjoint intervals 
              parent[p1]=p2;
              n--;
          }
        }
        return n;
    }
    public int find(int []parent, int n){ //returns parent of n
        while(parent[n]!=n){
            parent[n]=parent[parent[n]];
            n =parent[n];
        }
        return n;
    }
    
}
