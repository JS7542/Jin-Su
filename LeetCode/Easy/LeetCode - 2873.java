class Solution {
    /*
     * 모든 i<j<k 조합을 확인한다.
     * (nums[i]-nums[j])*nums[k] 값의 최댓값을 구하고 음수면 0을 반환한다.
     */
    public long maximumTripletValue(int[] nums) {
        long answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    answer = Math.max(answer, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        return answer;
    }
}
