class Solution {
    /*
     * 첫 번째 행의 각 시계 회전 횟수를 0~3으로 모두 시도한다.
     * 이전 행 시계를 12시로 맞추기 위해 다음 행의 회전 횟수는 유일하게 결정된다.
     */
    private int rows;
    private int cols;
    private final int[] dr = {0, -1, 1, 0, 0};
    private final int[] dc = {0, 0, 0, -1, 1};

    public int solution(int[][] clockHands) {
        rows = clockHands.length;
        cols = clockHands[0].length;

        int cases = 1;
        for (int col = 0; col < cols; col++) cases *= 4;

        int answer = Integer.MAX_VALUE;

        for (int mask = 0; mask < cases; mask++) {
            int[][] board = copy(clockHands);
            int encoded = mask;
            int rotations = 0;

            for (int col = 0; col < cols; col++) {
                int count = encoded % 4;
                encoded /= 4;
                rotate(board, 0, col, count);
                rotations += count;
            }

            for (int row = 1; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int count = (4 - board[row - 1][col]) % 4;
                    rotate(board, row, col, count);
                    rotations += count;
                }
            }

            boolean valid = true;

            for (int col = 0; col < cols; col++) {
                if (board[rows - 1][col] != 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) answer = Math.min(answer, rotations);
        }

        return answer;
    }

    private void rotate(int[][] board, int row, int col, int count) {
        if (count == 0) return;

        for (int direction = 0; direction < 5; direction++) {
            int nr = row + dr[direction];
            int nc = col + dc[direction];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

            board[nr][nc] = (board[nr][nc] + count) % 4;
        }
    }

    private int[][] copy(int[][] source) {
        int[][] copied = new int[rows][cols];

        for (int row = 0; row < rows; row++) copied[row] = source[row].clone();

        return copied;
    }
}
