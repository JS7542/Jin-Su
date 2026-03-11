class Solution {
    /*
     * 육지이면서 아직 방문하지 않은 칸마다 DFS를 시작한다.
     * 연결된 육지를 물로 바꾸며 탐색해 섬의 개수를 센다.
     */
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islands++;
                    sink(grid, row, col);
                }
            }
        }

        return islands;
    }

    private void sink(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || grid[row][col] != '1') return;

        grid[row][col] = '0';
        sink(grid, row - 1, col);
        sink(grid, row + 1, col);
        sink(grid, row, col - 1);
        sink(grid, row, col + 1);
    }
}
