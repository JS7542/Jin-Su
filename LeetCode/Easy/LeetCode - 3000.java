class Solution {
    /*
     * 각 직사각형의 대각선 길이 제곱과 넓이를 계산한다.
     * 대각선이 더 길거나 같을 때 넓이가 더 큰 직사각형을 선택한다.
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int bestDiagonal = 0;
        int bestArea = 0;

        for (int[] rectangle : dimensions) {
            int diagonal = rectangle[0] * rectangle[0] + rectangle[1] * rectangle[1];
            int area = rectangle[0] * rectangle[1];

            if (diagonal > bestDiagonal || (diagonal == bestDiagonal && area > bestArea)) {
                bestDiagonal = diagonal;
                bestArea = area;
            }
        }

        return bestArea;
    }
}
