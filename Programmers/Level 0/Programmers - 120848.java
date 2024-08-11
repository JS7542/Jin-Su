class Solution {
    /*
     * 1부터 차례로 곱해 팩토리얼 값을 만든다.
     * 다음 팩토리얼이 n을 초과하기 직전의 수를 반환한다.
     */
    public int solution(int n) {
        int factorial = 1;
        int value = 1;

        while (factorial * (value + 1) <= n) {
            value++;
            factorial *= value;
        }

        return value;
    }
}
