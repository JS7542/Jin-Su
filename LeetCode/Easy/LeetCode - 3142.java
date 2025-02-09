class Solution {
    /*
     * 세로로 인접한 칸은 같은지, 가로로 인접한 칸은 다른지 확인한다.
     * 모든 인접 조건을 만족하면 true를 반환한다.
     */
    public boolean satisfiesConditions(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (r > 0 && grid[r][c] != grid[r - 1][c]) return false;
                if (c > 0 && grid[r][c] == grid[r][c - 1]) return false;
            }
        }

        return true;
    }
}
