class Solution {
    /*
     * 행, 열, 3×3 박스별로 숫자 등장 여부를 기록한다.
     * 같은 영역에서 숫자가 중복되면 유효하지 않은 스도쿠다.
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                int number = board[r][c] - '1';
                int box = (r / 3) * 3 + c / 3;

                if (rows[r][number] || cols[c][number] || boxes[box][number]) {
                    return false;
                }

                rows[r][number] = true;
                cols[c][number] = true;
                boxes[box][number] = true;
            }
        }

        return true;
    }
}
