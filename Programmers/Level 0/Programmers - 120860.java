class Solution {
    /*
     * 네 점의 x좌표와 y좌표에서 각각 최솟값과 최댓값을 구한다.
     * 두 좌표 범위의 차를 곱해 직사각형 넓이를 계산한다.
     */
    public int solution(int[][] dots) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        for (int[] dot : dots) {
            minX = Math.min(minX, dot[0]);
            maxX = Math.max(maxX, dot[0]);
            minY = Math.min(minY, dot[1]);
            maxY = Math.max(maxY, dot[1]);
        }

        return (maxX - minX) * (maxY - minY);
    }
}
