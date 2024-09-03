class Solution {
    /*
     * x와 y의 양수·음수 여부를 조합해 네 사분면을 구분한다.
     * 조건에 맞는 사분면 번호를 반환한다.
     */
    public int solution(int[] dot) {
        if (dot[0] > 0 && dot[1] > 0) return 1;
        if (dot[0] < 0 && dot[1] > 0) return 2;
        if (dot[0] < 0) return 3;
        return 4;
    }
}
