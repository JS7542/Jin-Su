class Solution {
    /*
     * 1을 맨 앞으로, n을 맨 뒤로 이동하는 거리의 합을 계산한다.
     * 1의 위치가 n보다 뒤라면 이동 중 한 번 겹치므로 1을 뺀다.
     */
    public int semiOrderedPermutation(int[] nums) {
        int one = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) one = i;
            if (nums[i] == nums.length) max = i;
        }

        int answer = one + (nums.length - 1 - max);
        return one > max ? answer - 1 : answer;
    }
}
