class Solution {
    /*
     * 현재 값이 이전 값보다 크면 오름차순 구간 합에 이어 더한다.
     * 증가가 끊기면 현재 값부터 새 구간을 시작하며 최대 합을 갱신한다.
     */
    public int maxAscendingSum(int[] nums) {
        int current = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = nums[i] > nums[i - 1] ? current + nums[i] : nums[i];
            answer = Math.max(answer, current);
        }

        return answer;
    }
}
