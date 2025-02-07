class Solution {
    /*
     * 각 3×3 구간을 순회하며 최댓값을 찾는다.
     * 구간의 왼쪽 위 위치에 대응하는 결과 칸에 최댓값을 저장한다.
     */
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] answer = new int[n - 2][n - 2];

        for (int r = 0; r < n - 2; r++) {
            for (int c = 0; c < n - 2; c++) {
                int max = 0;

                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        max = Math.max(max, grid[i][j]);
                    }
                }

                answer[r][c] = max;
            }
        }

        return answer;
    }
}
