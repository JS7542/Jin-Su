class Solution {
    /*
     * number가 n과 m으로 모두 나누어떨어지는지 확인한다.
     * 두 수의 공배수이면 1, 아니면 0을 반환한다.
     */
    public int solution(int number, int n, int m) {
        return number % n == 0 && number % m == 0 ? 1 : 0;
    }
}
