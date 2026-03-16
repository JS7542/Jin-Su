class Solution {
    /*
     * 오른쪽 포인터를 늘려 부분배열 합을 키운다.
     * 합이 target 이상이면 왼쪽 포인터를 줄이며 가능한 최소 길이를 갱신한다.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left++];
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
