class Solution {
    /*
     * 원형 주택에서는 첫 집과 마지막 집을 동시에 털 수 없다.
     * 첫 집을 제외한 경우와 마지막 집을 제외한 경우의 선형 DP 최댓값을 비교한다.
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(
                robLinear(nums, 0, nums.length - 2),
                robLinear(nums, 1, nums.length - 1)
        );
    }

    private int robLinear(int[] nums, int start, int end) {
        int twoBack = 0;
        int oneBack = 0;

        for (int index = start; index <= end; index++) {
            int current = Math.max(oneBack, twoBack + nums[index]);
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
