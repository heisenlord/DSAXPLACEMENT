class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor=image[sr][sc];
        int[][] ans=image;
        int[] delRows={-1,0,1,0};
        int[] delCols={0,1,0,-1};
        dfs(sr,sc,image,ans,color,inicolor,delRows,delCols);
        return ans;
    }
    public void dfs(int sr,int sc,int[][] image,int[][] ans,int color,int inicolor,int[]delRows,int[] delCols)
    {
        ans[sr][sc]=color;
        for(int i=0;i<4;i++)
        {
            int row=sr+delRows[i];
            int col=sc+delCols[i];
            if(row>=0&&col>=0&&row<image.length&&col<image[0].length&&image[row][col]==inicolor&&ans[row][col]!=color)
            {
                dfs(row,col,image,ans,color,inicolor,delRows,delCols);
            }
        }
    }


}