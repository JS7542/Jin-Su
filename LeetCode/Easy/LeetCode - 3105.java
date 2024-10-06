class Solution {
    /*
     * 증가 구간 길이와 감소 구간 길이를 동시에 유지한다.
     * 현재와 이전 값의 관계에 따라 각 길이를 갱신하고 최댓값을 구한다.
     */
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 1;
        int decreasing = 1;
        int answer = 1;

        for (int i = 1; i < nums.length; i++) {
            increasing = nums[i] > nums[i - 1] ? increasing + 1 : 1;
            decreasing = nums[i] < nums[i - 1] ? decreasing + 1 : 1;
            answer = Math.max(answer, Math.max(increasing, decreasing));
        }

        return answer;
    }
}
