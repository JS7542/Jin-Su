class Solution {
    /*
     * 길이 n의 직사각형은 마지막에 세로 타일 하나 또는 가로 타일 두 개를 놓는다.
     * 피보나치 형태의 점화식을 1,000,000,007로 나눈 나머지로 계산한다.
     */
    public int solution(int n) {
        final int MOD = 1_000_000_007;

        if (n <= 2) return n;

        long twoBack = 1;
        long oneBack = 2;

        for (int length = 3; length <= n; length++) {
            long current = (twoBack + oneBack) % MOD;
            twoBack = oneBack;
            oneBack = current;
        }

        return (int) oneBack;
    }
}
