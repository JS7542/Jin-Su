class Solution {
    /*
     * 두 직사각형 넓이를 각각 계산한다.
     * 겹치는 가로·세로 길이가 양수이면 교집합 넓이를 한 번 빼 최종 합집합 넓이를 구한다.
     */
    public int computeArea(
            int ax1,
            int ay1,
            int ax2,
            int ay2,
            int bx1,
            int by1,
            int bx2,
            int by2
    ) {
        int firstArea = (ax2 - ax1) * (ay2 - ay1);
        int secondArea = (bx2 - bx1) * (by2 - by1);

        int overlapWidth = Math.max(
                0,
                Math.min(ax2, bx2) - Math.max(ax1, bx1)
        );
        int overlapHeight = Math.max(
                0,
                Math.min(ay2, by2) - Math.max(ay1, by1)
        );

        return firstArea + secondArea - overlapWidth * overlapHeight;
    }
}
