class Solution {
    /*
     * dp[value]에 주어진 동전으로 value를 만드는 조합 수를 저장한다.
     * 동전을 바깥 반복으로 처리해 순서가 다른 같은 조합을 중복 계산하지 않는다.
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int value = coin; value <= amount; value++) {
                dp[value] += dp[value - coin];
            }
        }

        return dp[amount];
    }
}
