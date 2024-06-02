class Solution {
    /*
     * 오른쪽, 아래, 왼쪽, 위 순서로 이동하며 1부터 n²까지 배열에 채운다.
     * 범위를 벗어나거나 이미 채운 칸을 만나면 다음 방향으로 회전한다.
     */
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int row = 0;
        int col = 0;
        int direction = 0;

        for (int number = 1; number <= n * n; number++) {
            answer[row][col] = number;
            int nr = row + dr[direction];
            int nc = col + dc[direction];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] != 0) {
                direction = (direction + 1) % 4;
                nr = row + dr[direction];
                nc = col + dc[direction];
            }

            row = nr;
            col = nc;
        }

        return answer;
    }
}
