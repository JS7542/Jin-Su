class Solution {
    /*
     * 시작 원소는 짝수이며 threshold 이하인 위치만 후보가 된다.
     * 이후 홀짝이 번갈아 나오고 threshold 이하인 동안 길이를 확장한다.
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int answer = 0;

        for (int start = 0; start < nums.length; start++) {
            if (nums[start] % 2 == 1 || nums[start] > threshold) continue;

            int end = start;

            while (end + 1 < nums.length
                    && nums[end + 1] <= threshold
                    && nums[end + 1] % 2 != nums[end] % 2) {
                end++;
            }

            answer = Math.max(answer, end - start + 1);
        }

        return answer;
    }
}
