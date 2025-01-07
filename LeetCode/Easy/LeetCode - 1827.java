class Solution {
    /*
     * 현재 값이 이전 값보다 크지 않으면 이전 값보다 1 크게 증가시킨다.
     * 증가시킨 차이를 연산 횟수에 누적한다.
     */
    public int minOperations(int[] nums) {
        int answer = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int next = nums[i - 1] + 1;
                answer += next - nums[i];
                nums[i] = next;
            }
        }

        return answer;
    }
}
