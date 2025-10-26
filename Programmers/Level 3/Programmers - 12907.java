class Solution {
    /*
     * dp[value]에 사용 가능한 동전으로 value를 만드는 조합 수를 저장한다.
     * 동전을 바깥 반복으로 두어 순서가 다른 같은 조합을 중복 계산하지 않는다.
     */
    public int solution(int n, int[] money) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int coin : money) {
            for (int value = coin; value <= n; value++) {
                dp[value] = (dp[value] + dp[value - coin]) % MOD;
            }
        }

        return (int) dp[n];
    }
}
