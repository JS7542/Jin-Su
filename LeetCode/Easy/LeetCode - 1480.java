class Solution {
    /*
     * 두 번째 원소부터 이전 위치의 누적합을 현재 값에 더한다.
     * 배열 자체를 누적합 배열로 바꾸어 반환한다.
     */
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        return nums;
    }
}
