class Solution {
    /*
     * 위쪽 투영은 0보다 큰 칸 수, 앞과 옆 투영은 각 행과 열의 최댓값 합이다.
     * 세 방향의 투영 넓이를 모두 더한다.
     */
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int top = 0;
        int front = 0;
        int side = 0;

        for (int r = 0; r < n; r++) {
            int rowMax = 0;
            int colMax = 0;

            for (int c = 0; c < n; c++) {
                if (grid[r][c] > 0) top++;
                rowMax = Math.max(rowMax, grid[r][c]);
                colMax = Math.max(colMax, grid[c][r]);
            }

            front += rowMax;
            side += colMax;
        }

        return top + front + side;
    }
}
