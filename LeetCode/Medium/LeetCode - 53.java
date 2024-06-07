class Solution {
    /*
     * 현재 위치에서 끝나는 최대 부분합과 전체 최대값을 동시에 갱신한다.
     * 이전 합을 이어가는 것과 현재 값부터 새로 시작하는 것 중 큰 값을 선택한다.
     */
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            answer = Math.max(answer, current);
        }

        return answer;
    }
}
