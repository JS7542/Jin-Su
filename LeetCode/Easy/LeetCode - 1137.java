class Solution {
    /*
     * 최근 세 트리보나치 수만 변수로 유지한다.
     * 세 수의 합으로 다음 값을 만들며 n번째 수까지 반복한다.
     */
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int first = 0;
        int second = 1;
        int third = 1;

        for (int i = 3; i <= n; i++) {
            int next = first + second + third;
            first = second;
            second = third;
            third = next;
        }

        return third;
    }
}
