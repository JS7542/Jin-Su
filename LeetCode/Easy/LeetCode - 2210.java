class Solution {
    /*
     * 연속 중복을 제거한 뒤 가운데 값이 양쪽보다 크거나 작은지 확인한다.
     * 봉우리와 골짜기에 해당하는 위치의 개수를 센다.
     */
    public int countHillValley(int[] nums) {
        int answer = 0;
        int previous = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) continue;

            if ((nums[i] > previous && nums[i] > nums[i + 1])
                    || (nums[i] < previous && nums[i] < nums[i + 1])) {
                answer++;
            }

            previous = nums[i];
        }

        return answer;
    }
}
