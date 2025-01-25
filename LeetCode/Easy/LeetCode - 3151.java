class Solution {
    /*
     * 인접한 두 원소의 홀짝이 서로 다른지 확인한다.
     * 같은 홀짝이 연속해서 나오면 특별한 배열이 아니다.
     */
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) return false;
        }

        return true;
    }
}
