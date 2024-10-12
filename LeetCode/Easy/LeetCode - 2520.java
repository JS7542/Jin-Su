class Solution {
    /*
     * 원래 수의 각 자리수를 하나씩 분리한다.
     * 자리수가 원래 수를 나누어떨어지게 하면 개수를 증가시킨다.
     */
    public int countDigits(int num) {
        int answer = 0;
        int value = num;

        while (value > 0) {
            int digit = value % 10;
            if (num % digit == 0) answer++;
            value /= 10;
        }

        return answer;
    }
}
