class Solution {
    /*
     * 배열 길이를 절반씩 줄이며 짝수 새 인덱스는 min, 홀수 새 인덱스는 max를 적용한다.
     * 원소가 하나 남을 때까지 반복한 값을 반환한다.
     */
    public int minMaxGame(int[] nums) {
        int length = nums.length;

        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                nums[i] = i % 2 == 0
                        ? Math.min(nums[2 * i], nums[2 * i + 1])
                        : Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            length /= 2;
        }

        return nums[0];
    }
}
