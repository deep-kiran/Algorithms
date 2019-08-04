class MazeSolver {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        if(maze.length==0)return false;
        int rowstart =start[0];
        int colstart =start[1];
        int rowdest =dest[0];
        int coldest =dest[1];
        int directions[][] =new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        if(rowstart==rowdest && colstart ==coldest)return true;
        boolean vis[][] =new boolean[maze.length][maze[0].length];
        Queue<Point> q =new LinkedList<>(); //bfs
        q.add(new Point(rowstart,colstart));
        vis[rowstart][colstart]=true;
        while(!q.isEmpty()){
            Point p =q.poll();
            int x= p.x;
            int y= p.y;
            for(int[]dir:directions){
                int xx = x;
                int yy = y;
                while(xx >=0 && xx<maze.length && yy>=0 && yy<maze[0].length && maze[xx][yy]==0){
                    xx += dir[0];
                    yy +=dir[1];
                }
                xx -=dir[0];
                yy -=dir[1];
                if(vis[xx][yy]){
                    continue;
                }
                vis[xx][yy]=true;
                if(xx ==rowdest && yy == coldest)return true;
                q.add(new Point(xx,yy));
            }
        }
        return false;
        
    }
}
