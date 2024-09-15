class Solution {
    /*
     * 유클리드 호제법으로 두 수의 최대공약수를 구한다.
     * 최소공배수는 두 수의 곱을 최대공약수로 나누어 계산한다.
     */
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[]{gcd, n / gcd * m};
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
