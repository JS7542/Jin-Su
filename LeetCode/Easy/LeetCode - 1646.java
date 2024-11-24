class Solution {
    /*
     * 문제의 짝수와 홀수 인덱스 생성 규칙으로 배열을 채운다.
     * 값을 생성하는 동안 전체 최댓값을 함께 갱신한다.
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;

        int[] nums = new int[n + 1];
        nums[1] = 1;
        int answer = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = i % 2 == 0 ? nums[i / 2] : nums[i / 2] + nums[i / 2 + 1];
            answer = Math.max(answer, nums[i]);
        }

        return answer;
    }
}
