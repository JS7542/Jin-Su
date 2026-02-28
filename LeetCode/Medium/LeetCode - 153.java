class Solution {
    /*
     * 중간값이 오른쪽 끝 값보다 크면 최솟값은 중간 오른쪽에 있다.
     * 그렇지 않으면 중간 위치를 포함한 왼쪽 구간으로 범위를 줄인다.
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        return nums[left];
    }
}
