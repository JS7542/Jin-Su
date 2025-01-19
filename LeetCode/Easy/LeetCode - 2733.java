class Solution {
    /*
     * 배열의 최솟값과 최댓값을 찾는다.
     * 두 값과 다른 원소를 하나 반환하고 없으면 -1을 반환한다.
     */
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) return -1;

        int min = nums[0];
        int max = nums[0];

        for (int number : nums) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        for (int number : nums) {
            if (number != min && number != max) return number;
        }

        return -1;
    }
}
