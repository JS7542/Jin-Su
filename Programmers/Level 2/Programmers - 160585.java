class Solution {
    /*
     * O와 X 개수 차이가 0 또는 1인지 확인한다.
     * 승리한 문자가 있다면 턴 수와 모순되지 않는지 검사한다.
     */
    public int solution(String[] board) {
        int circles = 0;
        int crosses = 0;

        for (String row : board) {
            for (char cell : row.toCharArray()) {
                if (cell == 'O') circles++;
                else if (cell == 'X') crosses++;
            }
        }

        if (!(circles == crosses || circles == crosses + 1)) return 0;

        boolean circleWins = wins(board, 'O');
        boolean crossWins = wins(board, 'X');

        if (circleWins && crossWins) return 0;
        if (circleWins && circles != crosses + 1) return 0;
        if (crossWins && circles != crosses) return 0;

        return 1;
    }

    private boolean wins(String[] board, char mark) {
        for (int index = 0; index < 3; index++) {
            if (board[index].charAt(0) == mark
                    && board[index].charAt(1) == mark
                    && board[index].charAt(2) == mark) return true;

            if (board[0].charAt(index) == mark
                    && board[1].charAt(index) == mark
                    && board[2].charAt(index) == mark) return true;
        }

        return board[0].charAt(0) == mark
                && board[1].charAt(1) == mark
                && board[2].charAt(2) == mark
                || board[0].charAt(2) == mark
                && board[1].charAt(1) == mark
                && board[2].charAt(0) == mark;
    }
}
