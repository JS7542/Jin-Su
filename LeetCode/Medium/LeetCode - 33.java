class Solution {
    /*
     * 중간값을 기준으로 왼쪽 또는 오른쪽 절반 중 정렬된 구간을 찾는다.
     * target이 정렬 구간 안에 있는지 판단해 탐색 범위를 절반으로 줄인다.
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }
}
