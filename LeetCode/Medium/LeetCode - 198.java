class Solution {
    /*
     * 현재 집을 털면 두 집 전 최대 금액에 현재 금액을 더한다.
     * 현재 집을 건너뛰는 경우와 비교해 각 위치의 최대 금액을 유지한다.
     */
    public int rob(int[] nums) {
        int twoBack = 0;
        int oneBack = 0;

        for (int money : nums) {
            int current = Math.max(oneBack, twoBack + money);
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
