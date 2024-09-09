class Solution {
    /*
     * num을 n으로 나눈 나머지를 확인한다.
     * 나누어떨어지면 1, 아니면 0을 반환한다.
     */
    public int solution(int num, int n) {
        return num % n == 0 ? 1 : 0;
    }
}
