class Solution {
    /*
     * 배열에서 최솟값과 최댓값을 찾는다.
     * 유클리드 호제법으로 두 값의 최대공약수를 구한다.
     */
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int number : nums) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        while (min != 0) {
            int temp = max % min;
            max = min;
            min = temp;
        }

        return max;
    }
}
