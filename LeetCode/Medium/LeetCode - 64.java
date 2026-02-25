class Solution {
    /*
     * 각 칸까지의 최소 합은 위쪽과 왼쪽 최소 합 중 작은 값에 현재 값을 더한 결과다.
     * 첫 행과 첫 열을 누적한 뒤 나머지 칸을 갱신한다.
     */
    public int minPathSum(int[][] grid) {
        for (int row = 1; row < grid.length; row++) {
            grid[row][0] += grid[row - 1][0];
        }

        for (int col = 1; col < grid[0].length; col++) {
            grid[0][col] += grid[0][col - 1];
        }

        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                grid[row][col] += Math.min(
                        grid[row - 1][col],
                        grid[row][col - 1]
                );
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
