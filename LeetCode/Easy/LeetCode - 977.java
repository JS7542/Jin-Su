class Solution {
    /*
     * 절댓값이 큰 원소가 양 끝에 있으므로 두 포인터로 비교한다.
     * 큰 제곱값부터 결과 배열의 뒤쪽에 채운다.
     */
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int write = nums.length - 1; write >= 0; write--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                answer[write] = nums[left] * nums[left++];
            } else {
                answer[write] = nums[right] * nums[right--];
            }
        }

        return answer;
    }
}
