class Solution {
    /*
     * 1부터 시작하는 인덱스가 배열 길이를 나누어떨어지게 하는지 확인한다.
     * 특별한 위치의 원소 제곱을 모두 합산한다.
     */
    public int sumOfSquares(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums.length % (i + 1) == 0) answer += nums[i] * nums[i];
        }

        return answer;
    }
}
