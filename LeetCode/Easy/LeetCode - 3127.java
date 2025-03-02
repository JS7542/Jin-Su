class Solution {
    /*
     * 가능한 모든 2×2 정사각형에서 흰색과 검은색 개수를 센다.
     * 한 색이 3개 이상이면 한 칸 이하 변경으로 같은 색 정사각형을 만들 수 있다.
     */
    public boolean canMakeSquare(char[][] grid) {
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 2; c++) {
                int black = 0;

                for (int i = r; i < r + 2; i++) {
                    for (int j = c; j < c + 2; j++) {
                        if (grid[i][j] == 'B') black++;
                    }
                }

                if (black != 2) return true;
            }
        }

        return false;
    }
}
