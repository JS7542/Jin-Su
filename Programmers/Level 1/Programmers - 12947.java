class Solution {
    /*
     * 원래 수의 각 자리수를 합산한다.
     * 원래 수가 자리수 합으로 나누어떨어지는지 확인한다.
     */
    public boolean solution(int x) {
        int sum = 0;
        int value = x;

        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }

        return x % sum == 0;
    }
}
