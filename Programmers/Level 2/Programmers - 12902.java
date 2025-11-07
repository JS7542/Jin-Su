class Solution {
    /*
     * 홀수 너비는 채울 수 없고 짝수 너비만 DP로 계산한다.
     * 기본 3가지 배치와 이전 짝수 구간에서 이어지는 특수 배치 2가지를 더한다.
     */
    public int solution(int n) {
        final long MOD = 1_000_000_007L;

        if (n % 2 == 1) return 0;

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int width = 2; width <= n; width += 2) {
            dp[width] = dp[width - 2] * 3 % MOD;

            for (int previous = width - 4; previous >= 0; previous -= 2) {
                dp[width] = (dp[width] + dp[previous] * 2) % MOD;
            }
        }

        return (int) dp[n];
    }
}
