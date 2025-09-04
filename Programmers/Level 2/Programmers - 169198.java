class Solution {
    /*
     * 목표 공을 네 벽에 대칭 이동시켜 한 번 쿠션 경로를 직선 거리로 바꾼다.
     * 목표 공을 먼저 맞히는 잘못된 같은 행·열 경로는 제외하고 최소 거리 제곱을 구한다.
     */
    public int[] solution(
            int m,
            int n,
            int startX,
            int startY,
            int[][] balls
    ) {
        int[] answer = new int[balls.length];

        for (int index = 0; index < balls.length; index++) {
            int ballX = balls[index][0];
            int ballY = balls[index][1];
            int minimum = Integer.MAX_VALUE;

            if (!(startY == ballY && ballX < startX)) {
                minimum = Math.min(
                        minimum,
                        distance(startX, startY, -ballX, ballY)
                );
            }

            if (!(startY == ballY && ballX > startX)) {
                minimum = Math.min(
                        minimum,
                        distance(startX, startY, 2 * m - ballX, ballY)
                );
            }

            if (!(startX == ballX && ballY < startY)) {
                minimum = Math.min(
                        minimum,
                        distance(startX, startY, ballX, -ballY)
                );
            }

            if (!(startX == ballX && ballY > startY)) {
                minimum = Math.min(
                        minimum,
                        distance(startX, startY, ballX, 2 * n - ballY)
                );
            }

            answer[index] = minimum;
        }

        return answer;
    }

    private int distance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;

        return dx * dx + dy * dy;
    }
}
