class Solution {
    /*
     * 두 수를 실수로 나눈 값에 1000을 곱한다.
     * 소수점 이하는 정수 변환으로 버리고 결과를 반환한다.
     */
    public int solution(int num1, int num2) {
        return (int) ((double) num1 / num2 * 1000);
    }
}
