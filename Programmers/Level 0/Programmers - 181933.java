class Solution {
    /*
     * flag가 true이면 두 정수의 합을 계산한다.
     * flag가 false이면 첫 번째 정수에서 두 번째 정수를 뺀다.
     */
    public int solution(int a, int b, boolean flag) {
        return flag ? a + b : a - b;
    }
}
