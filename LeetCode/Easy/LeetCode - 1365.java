class Solution {
    /*
     * 0부터 100까지 숫자별 빈도수를 센다.
     * 누적 빈도를 이용해 각 숫자보다 작은 값의 개수를 결과에 저장한다.
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int number : nums) count[number]++;

        for (int value = 1; value <= 100; value++) {
            count[value] += count[value - 1];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return answer;
    }
}
