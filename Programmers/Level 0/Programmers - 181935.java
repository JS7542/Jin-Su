class Solution {
    /*
     * n이 홀수이면 n 이하의 홀수 합을 계산한다.
     * n이 짝수이면 n 이하의 짝수 제곱 합을 계산한다.
     */
    public int solution(int n) {
        int answer = 0;

        if (n % 2 == 1) {
            for (int value = 1; value <= n; value += 2) answer += value;
        } else {
            for (int value = 2; value <= n; value += 2) answer += value * value;
        }

        return answer;
    }
}
