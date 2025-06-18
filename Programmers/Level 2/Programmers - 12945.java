class Solution {
    /*
     * 직전 두 피보나치 값을 유지하며 n번째 값까지 반복한다.
     * 각 계산 결과는 1,234,567로 나눈 나머지를 사용한다.
     */
    public int solution(int n) {
        final int MOD = 1_234_567;
        int twoBack = 0;
        int oneBack = 1;

        for (int index = 2; index <= n; index++) {
            int current = (twoBack + oneBack) % MOD;
            twoBack = oneBack;
            oneBack = current;
        }

        return n == 0 ? 0 : oneBack;
    }
}
