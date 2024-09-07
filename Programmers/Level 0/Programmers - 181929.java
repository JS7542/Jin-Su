class Solution {
    /*
     * 모든 원소의 곱과 모든 원소 합의 제곱을 계산한다.
     * 곱이 합의 제곱보다 작으면 1, 아니면 0을 반환한다.
     */
    public int solution(int[] num_list) {
        int product = 1;
        int sum = 0;

        for (int number : num_list) {
            product *= number;
            sum += number;
        }

        return product < sum * sum ? 1 : 0;
    }
}
