class Solution {
    /*
     * 순간 이동은 건전지를 사용하지 않고, 홀수 위치를 만들 때만 점프가 필요하다.
     * n의 이진 표현에서 1의 개수가 필요한 점프 횟수와 같다.
     */
    public int solution(int n) {
        return Integer.bitCount(n);
    }
}
