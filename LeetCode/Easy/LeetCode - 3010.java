class Solution {
    /*
     * 첫 번째 부분 배열은 반드시 nums[0]에서 시작한다.
     * 나머지 시작값으로 사용할 nums[1:]의 가장 작은 두 값을 더한다.
     */
    public int minimumCost(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < first) {
                second = first;
                first = nums[i];
            } else if (nums[i] < second) {
                second = nums[i];
            }
        }

        return nums[0] + first + second;
    }
}
