class Solution {
    /*
     * 전체 합을 구하고 왼쪽 합을 앞에서부터 누적한다.
     * 왼쪽 합과 현재 값을 제외한 오른쪽 합이 같으면 해당 인덱스를 반환한다.
     */
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        for (int number : nums) total += number;

        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (left == total - left - nums[i]) return i;
            left += nums[i];
        }

        return -1;
    }
}
