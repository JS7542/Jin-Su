class Solution {
    /*
     * n의 각 자리수를 분리하며 곱과 합을 동시에 계산한다.
     * 모든 자리 처리 후 자리수 곱에서 자리수 합을 뺀 값을 반환한다.
     */
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }

        return product - sum;
    }
}
