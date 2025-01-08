class Solution {
    /*
     * 전체 합을 오른쪽 합으로 시작하고 왼쪽 합은 0으로 시작한다.
     * 현재 원소를 오른쪽에서 제외한 뒤 두 합의 차이를 기록한다.
     */
    public int[] leftRightDifference(int[] nums) {
        int right = 0;
        for (int number : nums) right += number;

        int left = 0;
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            answer[i] = Math.abs(left - right);
            left += nums[i];
        }

        return answer;
    }
}
