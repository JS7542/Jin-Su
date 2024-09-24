class Solution {
    /*
     * 각도의 크기에 따라 예각, 직각, 둔각, 평각을 구분한다.
     * 문제에서 정한 분류 번호 1부터 4까지를 반환한다.
     */
    public int solution(int angle) {
        if (angle < 90) return 1;
        if (angle == 90) return 2;
        if (angle < 180) return 3;
        return 4;
    }
}
