class Solution {
    /*
     * 각 스킬의 직사각형 효과를 2차원 차분 배열 네 꼭짓점에 기록한다.
     * 행과 열 누적합으로 최종 변화량을 복원해 내구도가 양수인 건물 수를 센다.
     */
    public int solution(int[][] board, int[][] skill) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] difference = new int[rows + 1][cols + 1];

        for (int[] command : skill) {
            int degree = command[0] == 1 ? -command[5] : command[5];
            int r1 = command[1];
            int c1 = command[2];
            int r2 = command[3];
            int c2 = command[4];

            difference[r1][c1] += degree;
            difference[r1][c2 + 1] -= degree;
            difference[r2 + 1][c1] -= degree;
            difference[r2 + 1][c2 + 1] += degree;
        }

        for (int row = 0; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                difference[row][col] += difference[row][col - 1];
            }
        }

        for (int col = 0; col <= cols; col++) {
            for (int row = 1; row <= rows; row++) {
                difference[row][col] += difference[row - 1][col];
            }
        }

        int answer = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] + difference[row][col] > 0) answer++;
            }
        }

        return answer;
    }
}
