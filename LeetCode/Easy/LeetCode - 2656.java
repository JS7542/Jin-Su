class Solution {
    /*
     * 배열의 최댓값을 찾는다.
     * 최댓값부터 k개의 연속 정수를 선택한 등차수열 합을 계산한다.
     */
    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int number : nums) max = Math.max(max, number);
        return k * max + k * (k - 1) / 2;
    }
}
