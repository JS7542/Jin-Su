class Solution {
    /*
     * 정렬 배열에서 첫 0 이상 위치와 첫 양수 위치를 이분 탐색한다.
     * 음수 개수와 양수 개수 중 큰 값을 반환한다.
     */
    public int maximumCount(int[] nums) {
        int negative = lowerBound(nums, 0);
        int positive = nums.length - lowerBound(nums, 1);
        return Math.max(negative, positive);
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
