class Solution {
    /*
     * n이 짝수이면 n 자체가 2와 n의 최소공배수다.
     * n이 홀수이면 2를 곱한 값이 최소공배수다.
     */
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
