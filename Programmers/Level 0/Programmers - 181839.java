class Solution {
    /*
     * 두 수가 모두 홀수인지, 하나만 홀수인지, 모두 짝수인지 확인한다.
     * 조건에 따라 제곱의 합, 합의 두 배, 차의 절댓값을 반환한다.
     */
    public int solution(int a, int b) {
        if (a % 2 == 1 && b % 2 == 1) return a * a + b * b;
        if (a % 2 != b % 2) return 2 * (a + b);
        return Math.abs(a - b);
    }
}
