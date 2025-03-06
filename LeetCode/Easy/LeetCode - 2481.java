class Solution {
    /*
     * 조각이 1개면 자를 필요가 없다.
     * 짝수 조각은 n/2번, 홀수 조각은 n번 잘라야 한다.
     */
    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        return n % 2 == 0 ? n / 2 : n;
    }
}
