import java.util.*;

class Solution {
    /*
     * dp[value]에 value를 제곱수 합으로 만드는 최소 항 개수를 저장한다.
     * value 이하의 모든 제곱수를 마지막 항으로 사용하는 경우를 비교한다.
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int value = 1; value <= n; value++) {
            for (int root = 1; root * root <= value; root++) {
                dp[value] = Math.min(
                        dp[value],
                        dp[value - root * root] + 1
                );
            }
        }

        return dp[n];
    }
}
