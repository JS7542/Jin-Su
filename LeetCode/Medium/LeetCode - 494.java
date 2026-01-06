class Solution {
    /*
     * 각 숫자에 더하기와 빼기를 적용하는 두 경우를 재귀적으로 탐색한다.
     * 모든 숫자를 사용했을 때 목표 합과 같은 경로 수를 센다.
     */
    public int findTargetSumWays(int[] nums, int target) {
        return search(nums, target, 0, 0);
    }

    private int search(int[] nums, int target, int index, int sum) {
        if (index == nums.length) return sum == target ? 1 : 0;

        return search(nums, target, index + 1, sum + nums[index])
                + search(nums, target, index + 1, sum - nums[index]);
    }
}
