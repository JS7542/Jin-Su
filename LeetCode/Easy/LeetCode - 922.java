class Solution {
    /*
     * 짝수 인덱스에서 잘못 배치된 홀수와 홀수 인덱스에서 잘못 배치된 짝수를 찾는다.
     * 두 값을 교환하며 각 인덱스와 같은 홀짝 성질을 갖도록 만든다.
     */
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;

        while (even < nums.length && odd < nums.length) {
            while (even < nums.length && nums[even] % 2 == 0) even += 2;
            while (odd < nums.length && nums[odd] % 2 == 1) odd += 2;

            if (even < nums.length && odd < nums.length) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }

        return nums;
    }
}
