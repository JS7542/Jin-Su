class Solution {
    /*
     * 분모를 분자와의 최대공약수로 나누어 기약분수의 분모를 만든다.
     * 남은 분모의 소인수가 2와 5뿐이면 유한소수이므로 1을 반환한다.
     */
    public int solution(int a, int b) {
        b /= gcd(a, b);
        while (b % 2 == 0) b /= 2;
        while (b % 5 == 0) b /= 5;
        return b == 1 ? 1 : 2;
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
