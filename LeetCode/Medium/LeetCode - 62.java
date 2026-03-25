import java.util.*;

class Solution {
    /*
     * 각 칸에 도달하는 경로 수는 위쪽과 왼쪽 경로 수의 합이다.
     * 한 행짜리 DP 배열을 사용해 공간을 줄인다.
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[col] += dp[col - 1];
            }
        }

        return dp[n - 1];
    }
}
