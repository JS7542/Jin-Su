class Solution {
    /*
     * 테두리와 연결된 O를 DFS로 임시 문자로 표시한다.
     * 남은 O는 X로 바꾸고 임시 문자는 다시 O로 복원한다.
     */
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            mark(board, row, 0);
            mark(board, row, cols - 1);
        }

        for (int col = 0; col < cols; col++) {
            mark(board, 0, col);
            mark(board, rows - 1, col);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
                else if (board[row][col] == '#') board[row][col] = 'O';
            }
        }
    }

    private void mark(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != 'O') return;

        board[row][col] = '#';
        mark(board, row - 1, col);
        mark(board, row + 1, col);
        mark(board, row, col - 1);
        mark(board, row, col + 1);
    }
}
