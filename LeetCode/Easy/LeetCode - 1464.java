class Solution {
    /*
     * 배열을 한 번 순회하며 가장 큰 두 값을 유지한다.
     * 두 값에서 각각 1을 뺀 뒤 곱한 결과를 반환한다.
     */
    public int maxProduct(int[] nums) {
        int first = 0;
        int second = 0;

        for (int number : nums) {
            if (number > first) {
                second = first;
                first = number;
            } else if (number > second) {
                second = number;
            }
        }

        return (first - 1) * (second - 1);
    }
}
