class Solution {
    /*
     * 두 직사각형이 x축과 y축에서 모두 양의 길이로 겹치는지 확인한다.
     * 한 축이라도 분리되어 있으면 겹치는 넓이가 없다.
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2]
                && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}
