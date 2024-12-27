class Solution {
    /*
     * 양 끝 포인터를 사용해 왼쪽의 홀수와 오른쪽의 짝수를 교환한다.
     * 모든 짝수가 홀수보다 앞에 오도록 배열을 재배치한다.
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 0) left++;
            while (left < right && nums[right] % 2 == 1) right--;

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}
