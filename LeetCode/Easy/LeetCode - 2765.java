class Solution {
    /*
     * 시작 두 값의 차이가 1인 구간만 후보가 된다.
     * 이후 차이가 -1과 1로 번갈아 나타나는 동안 길이를 확장한다.
     */
    public int alternatingSubarray(int[] nums) {
        int answer = -1;

        for (int start = 0; start + 1 < nums.length; start++) {
            if (nums[start + 1] - nums[start] != 1) continue;

            int end = start + 1;
            int expected = -1;

            while (end + 1 < nums.length
                    && nums[end + 1] - nums[end] == expected) {
                end++;
                expected *= -1;
            }

            answer = Math.max(answer, end - start + 1);
        }

        return answer;
    }
}
