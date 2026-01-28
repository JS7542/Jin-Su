class Solution {
    /*
     * 현재 칸은 한 칸 전에서 1칸 뛰거나 두 칸 전에서 2칸 뛰어 도달한다.
     * 피보나치 점화식을 1,234,567로 나눈 나머지로 계산한다.
     */
    public long solution(int n) {
        final int MOD = 1_234_567;

        if (n <= 2) return n;

        long twoBack = 1;
        long oneBack = 2;

        for (int distance = 3; distance <= n; distance++) {
            long current = (twoBack + oneBack) % MOD;
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
