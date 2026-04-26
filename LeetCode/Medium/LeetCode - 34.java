class Solution {
    /*
     * target 이상이 처음 나오는 위치와 target보다 큰 값이 처음 나오는 위치를 구한다.
     * 두 경계로 target의 시작과 끝 인덱스를 계산한다.
     */
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);

        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }

        int last = lowerBound(nums, target + 1) - 1;
        return new int[]{first, last};
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
