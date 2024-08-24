class Solution {
    /*
     * 각 수를 최대 K만큼 조절하면 전체 범위는 양쪽에서 K씩 줄일 수 있다.
     * 기존 최댓값과 최솟값의 차에서 2K를 뺀 값과 0 중 큰 값을 반환한다.
     */
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int number : nums) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        return Math.max(0, max - min - 2 * k);
    }
}
