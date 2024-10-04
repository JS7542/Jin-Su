class Solution {
    /*
     * 한 판의 조각 수 slice로 n명에게 한 조각 이상 나누어준다.
     * 올림 나눗셈인 (n+slice-1)/slice로 최소 판 수를 구한다.
     */
    public int solution(int slice, int n) {
        return (n + slice - 1) / slice;
    }
}
