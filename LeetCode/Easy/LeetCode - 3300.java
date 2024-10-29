class Solution {
    /*
     * 각 배열 원소의 자리수 합을 계산한다.
     * 모든 자리수 합 중 최솟값을 반환한다.
     */
    public int minElement(int[] nums) {
        int answer = Integer.MAX_VALUE;

        for (int number : nums) {
            int sum = 0;

            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }

            answer = Math.min(answer, sum);
        }

        return answer;
    }
}
