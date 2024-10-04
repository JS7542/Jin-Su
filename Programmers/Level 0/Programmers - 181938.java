class Solution {
    /*
     * a+b 값과 2*a*b 값을 각각 계산한다.
     * 두 결과 중 더 큰 값을 반환한다.
     */
    public int solution(int a, int b) {
        return Math.max(a + b, 2 * a * b);
    }
}
