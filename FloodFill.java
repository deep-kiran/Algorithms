class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int col = image[sr][sc];
        if(col!=newColor)dfs(image,sr,sc,col,newColor);
        return image;
    }
    public void dfs(int [][]image, int sr, int sc, int col, int newcol){
        if(sr<0 || sr>= image.length|| sc <0 ||sc>=image[0].length|| image[sr][sc]!=col)return;
            image[sr][sc]=newcol;
            dfs(image,sr+1,sc,col,newcol);
            dfs(image,sr-1,sc,col,newcol);
            dfs(image,sr,sc+1,col,newcol);
            dfs(image,sr,sc-1,col,newcol); 
    }
}
