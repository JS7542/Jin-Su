class Solution {
    /*
     * 연, 월, 일을 하나의 비교 가능한 정수 형태로 변환한다.
     * date1이 date2보다 앞선 날짜이면 1, 아니면 0을 반환한다.
     */
    public int solution(int[] date1, int[] date2) {
        int first = date1[0] * 10000 + date1[1] * 100 + date1[2];
        int second = date2[0] * 10000 + date2[1] * 100 + date2[2];
        return first < second ? 1 : 0;
    }
}
