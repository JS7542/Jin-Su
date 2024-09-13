class Solution {
    /*
     * 모든 인덱스 쌍을 확인한다.
     * 인덱스 차이와 값 차이 조건을 모두 만족하는 첫 쌍을 반환한다.
     */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(i - j) >= indexDifference
                        && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
