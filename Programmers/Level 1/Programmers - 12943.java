class Solution {
    /*
     * 짝수는 2로 나누고 홀수는 3을 곱한 뒤 1을 더하는 연산을 반복한다.
     * 500회 안에 1이 되면 횟수를, 아니면 -1을 반환한다.
     */
    public int solution(int num) {
        long value = num;

        for (int count = 0; count <= 500; count++) {
            if (value == 1) return count;
            value = value % 2 == 0 ? value / 2 : value * 3 + 1;
        }

        return -1;
    }
}
