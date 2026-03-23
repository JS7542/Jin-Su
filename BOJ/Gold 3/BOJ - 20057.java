import java.io.*;
import java.util.*;

class Main {
    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {-1, 0, 1, 0};

    static final int[][] SPREAD_R = {
        {-1, 1, -2, 2, -1, 1, -1, 1, 0},
        {-1, -1, 0, 0, 1, 1, 2, 2, 3},
        {-1, 1, -2, 2, -1, 1, -1, 1, 0},
        {1, 1, 0, 0, -1, -1, -2, -2, -3}
    };

    static final int[][] SPREAD_C = {
        {1, 1, 0, 0, 0, 0, -1, -1, -2},
        {-1, 1, -2, 2, -1, 1, -1, 1, 0},
        {-1, -1, 0, 0, 0, 0, 1, 1, 2},
        {-1, 1, -2, 2, -1, 1, -1, 1, 0}
    };

    static final int[] PERCENT = {1, 1, 2, 2, 7, 7, 10, 10, 5};

    /*
     * 중앙에서 좌·하·우·상 순으로 달팽이 이동하며 모래를 분산한다.
     * 방향별 비율 좌표에 모래를 보내고 남은 모래는 알파 칸으로 이동시킨다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < n; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int row = n / 2;
        int col = n / 2;
        int direction = 0;
        int distance = 1;
        int answer = 0;

        while (!(row == 0 && col == 0)) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int step = 0; step < distance; step++) {
                    row += DR[direction];
                    col += DC[direction];

                    answer += spread(board, row, col, direction);

                    if (row == 0 && col == 0) {
                        System.out.print(answer);
                        return;
                    }
                }

                direction = (direction + 1) % 4;
            }

            distance++;
        }
    }

    static int spread(int[][] board, int row, int col, int direction) {
        int n = board.length;
        int sand = board[row][col];
        board[row][col] = 0;

        int moved = 0;
        int outside = 0;

        for (int index = 0; index < PERCENT.length; index++) {
            int amount = sand * PERCENT[index] / 100;
            int nr = row + SPREAD_R[direction][index];
            int nc = col + SPREAD_C[direction][index];

            moved += amount;

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) outside += amount;
            else board[nr][nc] += amount;
        }

        int alpha = sand - moved;
        int alphaRow = row + DR[direction];
        int alphaCol = col + DC[direction];

        if (alphaRow < 0 || alphaRow >= n || alphaCol < 0 || alphaCol >= n) {
            outside += alpha;
        } else {
            board[alphaRow][alphaCol] += alpha;
        }

        return outside;
    }
}
