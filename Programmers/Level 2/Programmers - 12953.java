class Solution {
    /*
     * 현재까지의 최소공배수와 다음 숫자의 최소공배수를 순서대로 계산한다.
     * 두 수의 최소공배수는 a/gcd(a,b)*b로 구한다.
     */
    public int solution(int[] arr) {
        long lcm = 1;

        for (int number : arr) {
            lcm = lcm / gcd(lcm, number) * number;
        }

        return (int) lcm;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
