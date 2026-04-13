class Solution {
    /*
     * 중간값과 양 끝 값이 모두 같으면 경계를 한 칸씩 줄인다.
     * 그 외에는 정렬된 절반을 찾아 target이 포함되는 쪽으로 범위를 좁힌다.
     */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return false;
    }
}
