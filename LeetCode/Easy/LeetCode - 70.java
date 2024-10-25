class Solution {
    /*
     * n번째 계단에 도달하는 방법 수는 이전 두 계단 방법 수의 합이다.
     * 두 변수만 유지해 피보나치 형태의 점화식을 계산한다.
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }

        return second;
    }
}
