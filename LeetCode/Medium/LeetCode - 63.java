class Solution {
    /*
     * 장애물이 있는 칸의 경로 수는 0으로 만든다.
     * 그 외 칸은 위쪽과 왼쪽 경로 수를 더해 한 행 DP로 계산한다.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int columns = obstacleGrid[0].length;
        int[] dp = new int[columns];
        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int col = 0; col < columns; col++) {
                if (row[col] == 1) dp[col] = 0;
                else if (col > 0) dp[col] += dp[col - 1];
            }
        }

        return dp[columns - 1];
    }
}
