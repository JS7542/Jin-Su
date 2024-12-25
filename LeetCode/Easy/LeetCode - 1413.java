class Solution {
    /*
     * 배열을 순서대로 더하며 누적합의 최솟값을 구한다.
     * 모든 단계 합이 1 이상이 되도록 1에서 최소 누적합을 뺀 값을 반환한다.
     */
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minimum = 0;

        for (int number : nums) {
            sum += number;
            minimum = Math.min(minimum, sum);
        }

        return 1 - minimum;
    }
}
