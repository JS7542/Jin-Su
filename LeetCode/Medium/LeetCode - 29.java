class Solution {
    /*
     * 제수의 2의 거듭제곱 배를 큰 값부터 빼며 몫 비트를 채운다.
     * long으로 오버플로를 방지하고 32비트 정수 범위를 넘는 결과는 최댓값으로 제한한다.
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);
        long remaining = Math.abs((long) dividend);
        long base = Math.abs((long) divisor);
        long quotient = 0;

        for (int shift = 31; shift >= 0; shift--) {
            long multiple = base << shift;

            if (multiple <= remaining) {
                remaining -= multiple;
                quotient += 1L << shift;
            }
        }

        if (negative) quotient = -quotient;

        return (int) quotient;
    }
}
