class Solution {
    /*
     * 짝수는 2로 나누고 홀수는 1을 빼는 연산을 반복한다.
     * num이 0이 될 때까지 수행한 연산 횟수를 센다.
     */
    public int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
            steps++;
        }

        return steps;
    }
}
