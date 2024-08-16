class Solution {
    /*
     * 배열 앞에서부터 원소를 차례대로 합산한다.
     * 누적합이 n보다 커지는 순간의 값을 반환한다.
     */
    public int solution(int[] numbers, int n) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
            if (sum > n) return sum;
        }

        return sum;
    }
}
