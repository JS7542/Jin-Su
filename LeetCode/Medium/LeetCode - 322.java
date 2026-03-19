import java.util.*;

class Solution {
    /*
     * dp[value]에 해당 금액을 만드는 최소 동전 수를 저장한다.
     * 각 금액에서 모든 동전을 확인해 이전 금액의 최솟값에 1을 더한다.
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int value = 1; value <= amount; value++) {
            for (int coin : coins) {
                if (coin <= value) {
                    dp[value] = Math.min(dp[value], dp[value - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
