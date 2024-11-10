class Solution {
    /*
     * 완전한 주 수와 남은 일수를 나누어 계산한다.
     * 각 주의 시작 금액이 1씩 증가하는 등차수열 합을 사용한다.
     */
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;

        int fullWeeks = 28 * weeks + 7 * weeks * (weeks - 1) / 2;
        int remaining = days * (weeks + 1) + days * (days - 1) / 2;

        return fullWeeks + remaining;
    }
}
