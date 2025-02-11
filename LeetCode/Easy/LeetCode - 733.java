class Solution {
    /*
     * 시작 셀의 원래 색을 저장하고 연결된 같은 색 셀을 DFS로 탐색한다.
     * 방문한 셀을 새 색으로 바꾸며 범위 밖과 다른 색에서는 탐색을 멈춘다.
     */
    public int[][] floodFill(int[][] image,int sr,int sc,int color){int old=image[sr][sc];if(old!=color)dfs(image,sr,sc,old,color);return image;}private void dfs(int[][]a,int r,int c,int old,int color){if(r<0||r==a.length||c<0||c==a[0].length||a[r][c]!=old)return;a[r][c]=color;dfs(a,r+1,c,old,color);dfs(a,r-1,c,old,color);dfs(a,r,c+1,old,color);dfs(a,r,c-1,old,color);}
}
