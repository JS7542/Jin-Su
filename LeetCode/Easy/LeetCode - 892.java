class Solution {
    /*
     * 높이가 있는 각 칸은 위아래 면 2개와 높이에 따른 옆면 4개를 가진다.
     * 위쪽과 왼쪽 이웃과 겹치는 면을 높이의 최솟값만큼 두 번 뺀다.
     */
    public int surfaceArea(int[][] grid) {
        int area = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int height = grid[r][c];
                if (height == 0) continue;

                area += 2 + height * 4;
                if (r > 0) area -= Math.min(height, grid[r - 1][c]) * 2;
                if (c > 0) area -= Math.min(height, grid[r][c - 1]) * 2;
            }
        }

        return area;
    }
}
