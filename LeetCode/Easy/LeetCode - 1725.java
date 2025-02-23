class Solution {
    /*
     * 각 직사각형이 만들 수 있는 정사각형 변은 두 변 중 작은 값이다.
     * 최대 변 길이와 그 길이를 만드는 직사각형 개수를 유지한다.
     */
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int answer = 0;

        for (int[] rectangle : rectangles) {
            int side = Math.min(rectangle[0], rectangle[1]);

            if (side > max) {
                max = side;
                answer = 1;
            } else if (side == max) {
                answer++;
            }
        }

        return answer;
    }
}
