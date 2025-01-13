class Solution {
    /*
     * 각 땅 칸은 기본 둘레 4를 더하고 위쪽과 왼쪽의 인접 땅마다 공유 변 2를 뺀다.
     * 모든 땅 칸을 순회해 전체 섬 둘레를 계산한다.
     */
    public int islandPerimeter(int[][] grid){int ans=0;for(int r=0;r<grid.length;r++)for(int c=0;c<grid[0].length;c++)if(grid[r][c]==1){ans+=4;if(r>0&&grid[r-1][c]==1)ans-=2;if(c>0&&grid[r][c-1]==1)ans-=2;}return ans;}
}
