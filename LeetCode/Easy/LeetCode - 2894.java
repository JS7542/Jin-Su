class Solution {
    /*
     * 1부터 n까지 m의 배수는 두 번째 합에, 나머지는 첫 번째 합에 더한다.
     * 두 합의 차이를 반환한다.
     */
    public int differenceOfSums(int n, int m) {
        int answer = 0;

        for (int value = 1; value <= n; value++) {
            answer += value % m == 0 ? -value : value;
        }

        return answer;
    }
}
