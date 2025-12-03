class Solution {
    /*
     * 값이 1인 칸을 오른쪽 아래 꼭짓점으로 하는 최대 정사각형 변 길이를 계산한다.
     * 위, 왼쪽, 왼쪽 위 DP 값의 최솟값에 1을 더한다.
     */
    public int solution(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int answer = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 0) continue;

                if (row > 0 && col > 0) {
                    board[row][col] = Math.min(
                            board[row - 1][col - 1],
                            Math.min(board[row - 1][col], board[row][col - 1])
                    ) + 1;
                }

                answer = Math.max(answer, board[row][col]);
            }
        }

        return answer * answer;
    }
}
