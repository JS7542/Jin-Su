class Solution {
    /*
     * 이분 탐색으로 target 이상인 값이 처음 나타나는 위치를 찾는다.
     * 해당 위치는 target이 없을 때 삽입해야 하는 인덱스와 동일하다.
     */
    public int searchInsert(int[] nums, int target) {
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
