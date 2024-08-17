class Solution {
    /*
     * 두 수 중 큰 수에서 작은 수를 빼는 연산을 반복한다.
     * 둘 중 하나가 0이 될 때까지의 연산 횟수를 센다.
     */
    public int countOperations(int num1, int num2) {
        int answer = 0;

        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) num1 -= num2;
            else num2 -= num1;
            answer++;
        }

        return answer;
    }
}
