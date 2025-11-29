class Solution {
    /*
     * 웅덩이 위치를 표시하고 각 칸까지 오는 경로 수를 DP로 계산한다.
     * 현재 칸의 경로 수는 위쪽과 왼쪽 경로 수의 합이다.
     */
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        boolean[][] blocked = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) blocked[puddle[1]][puddle[0]] = true;

        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                if (blocked[row][col]) {
                    dp[row][col] = 0;
                    continue;
                }

                if (row == 1 && col == 1) continue;

                dp[row][col] = (int) (
                        ((long) dp[row - 1][col] + dp[row][col - 1]) % MOD
                );
            }
        }

        return dp[n][m];
    }
}
