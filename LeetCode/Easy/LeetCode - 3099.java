class Solution {
    /*
     * x의 각 자리수를 합산한다.
     * x가 자리수 합으로 나누어떨어지면 합을, 아니면 -1을 반환한다.
     */
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int value = x;

        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }

        return x % sum == 0 ? sum : -1;
    }
}
