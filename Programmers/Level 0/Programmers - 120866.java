class Solution {
    /*
     * 지뢰가 있는 모든 칸을 기준으로 주변 8칸과 자기 자신을 위험 지역으로 표시한다.
     * 표시되지 않은 칸의 개수를 세어 안전지대 크기를 반환한다.
     */
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] danger = new boolean[n][n];
        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] != 1) continue;

                for (int d = 0; d < 9; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) danger[nr][nc] = true;
                }
            }
        }

        int answer = 0;
        for (boolean[] row : danger) {
            for (boolean value : row) if (!value) answer++;
        }
        return answer;
    }
}
