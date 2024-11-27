class Solution {
    /*
     * n이 홀수이면 a를 n개 사용하면 등장 횟수가 홀수다.
     * n이 짝수이면 a를 n-1개, b를 1개 사용해 두 문자 빈도를 모두 홀수로 만든다.
     */
    public String generateTheString(int n) {
        if (n % 2 == 1) return "a".repeat(n);
        return "a".repeat(n - 1) + "b";
    }
}
