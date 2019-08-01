class MakeGolfCourse {
    int directions [][]={{0,1},{0,-1},{1,0},{-1,0}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int r =forest.size();
        int c =forest.get(0).size();
        PriorityQueue<int[]> trees =new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int val =forest.get(i).get(j);
                if(val>1){
                    int ele[]= new int[3];
                    ele[0]=i;
                    ele[1]=j;
                    ele[2]=val;
                    trees.add(ele);
                }
            }
        }
        int minsteps=0;
        int currX=0;
        int currY=0;
        while(!trees.isEmpty()){
            int currTree[] =trees.poll();
            int steps =minsteps(forest,currTree[0],currTree[1],currX,currY);
            if(steps==-1)return -1;
            minsteps +=steps;
            currX=currTree[0];
            currY=currTree[1]; 
            forest.get(currX).set(currY,1);
                    
        }
        return minsteps;
    }
    public int minsteps(List<List<Integer>> forest, int aimX, int aimY, int currX, int currY){
        int minsteps=0;
        Queue<int[]> q =new LinkedList<>();
        int r =forest.size();
        int c =forest.get(0).size();
        boolean vis[][] =new boolean[r][c];
        vis[currX][currY]=true;
        q.add(new int[]{currX, currY});
        while(!q.isEmpty()){
            int size =q.size();
            for(int i=0;i<size;i++){
                int arr[] =q.poll();
                if(arr[0]==aimX && arr[1]==aimY){
                    return minsteps;
                }
                for(int dir[]:directions){
                    int nx =arr[0]+dir[0];
                    int ny =arr[1]+dir[1];
                    if(nx>=0 && nx< r && ny >=0 && ny< c && !vis[nx][ny] && forest.get(nx).get(ny)!=0){
                        vis[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            minsteps++;
        }
        return -1;
    }
}
