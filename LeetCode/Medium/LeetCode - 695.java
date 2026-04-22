class Solution {
    /*
     * 육지 칸에서 DFS를 시작해 연결된 육지의 넓이를 계산한다.
     * 방문한 칸은 0으로 바꾸고 모든 섬 넓이의 최댓값을 구한다.
     */
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    answer = Math.max(answer, area(grid, row, col));
                }
            }
        }

        return answer;
    }

    private int area(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        return 1
                + area(grid, row - 1, col)
                + area(grid, row + 1, col)
                + area(grid, row, col - 1)
                + area(grid, row, col + 1);
    }
}
