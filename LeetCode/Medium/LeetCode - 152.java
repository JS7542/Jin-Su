class Solution {
    /*
     * 음수를 곱하면 최댓값과 최솟값 역할이 바뀔 수 있다.
     * 각 위치에서 끝나는 최대 곱과 최소 곱을 함께 유지한다.
     */
    public int maxProduct(int[] nums) {
        int maximum = nums[0];
        int minimum = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];

            if (value < 0) {
                int temp = maximum;
                maximum = minimum;
                minimum = temp;
            }

            maximum = Math.max(value, maximum * value);
            minimum = Math.min(value, minimum * value);
            answer = Math.max(answer, maximum);
        }

        return answer;
    }
}
