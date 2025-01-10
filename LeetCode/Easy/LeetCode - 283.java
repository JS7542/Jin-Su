class Solution {
    /*
     * 0이 아닌 값을 앞쪽부터 순서대로 덮어쓴다.
     * 남은 뒤쪽 위치를 모두 0으로 채워 상대 순서를 유지한다.
     */
    public void moveZeroes(int[] nums) {
        int write = 0;

        for (int number : nums) {
            if (number != 0) nums[write++] = number;
        }

        while (write < nums.length) nums[write++] = 0;
    }
}
