class Solution {
    /*
     * 뒤에서부터 처음 감소하는 위치를 찾는다.
     * 그 값보다 큰 가장 오른쪽 값을 교환한 뒤 뒷부분을 뒤집는다.
     */
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;

        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--;

        if (pivot >= 0) {
            int larger = nums.length - 1;

            while (nums[larger] <= nums[pivot]) larger--;

            swap(nums, pivot, larger);
        }

        reverse(nums, pivot + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) swap(nums, left++, right--);
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
