class Solution {
    /*
     * dp[target]에 순서를 고려해 target을 만드는 경우의 수를 저장한다.
     * 합을 바깥 반복으로 두고 각 숫자를 마지막에 붙이는 경우를 더한다.
     */
    public int combinationSum4(int[] nums, int target) {
        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= target; sum++) {
            for (int number : nums) {
                if (number <= sum) dp[sum] += dp[sum - number];
            }
        }

        return (int) dp[target];
    }
}
