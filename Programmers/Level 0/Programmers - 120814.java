class Solution {
    /*
     * 피자 한 판은 일곱 조각이므로 n명을 모두 먹이려면 올림 나눗셈이 필요하다.
     * (n+6)/7로 필요한 최소 판 수를 계산한다.
     */
    public int solution(int n) {
        return (n + 6) / 7;
    }
}
