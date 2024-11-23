class Solution {
    /*
     * 배열의 최솟값과 최댓값을 찾는다.
     * 두 값 사이에 엄격히 위치하는 원소의 개수를 센다.
     */
    public int countElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int number : nums) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        int answer = 0;
        for (int number : nums) {
            if (min < number && number < max) answer++;
        }

        return answer;
    }
}
