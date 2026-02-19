class Solution {
    /*
     * 중간값이 오른쪽 값보다 작으면 상승 중이므로 봉우리는 오른쪽에 있다.
     * 그렇지 않으면 중간을 포함한 왼쪽 구간에 봉우리가 존재한다.
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
