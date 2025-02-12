class Solution {
    /*
     * 양 끝 숫자를 문자열로 이어 붙여 하나의 정수로 만든다.
     * 포인터가 만나는 경우 가운데 숫자는 그대로 합산한다.
     */
    public long findTheArrayConcVal(int[] nums) {
        long answer = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left == right) answer += nums[left];
            else answer += Long.parseLong(String.valueOf(nums[left]) + nums[right]);

            left++;
            right--;
        }

        return answer;
    }
}
