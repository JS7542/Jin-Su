import java.io.*;
import java.util.*;

class Main {
    static class Shark {
        int row;
        int col;
        int speed;
        int direction;
        int size;

        Shark(int row, int col, int speed, int direction, int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }

    /*
     * 낚시왕이 열을 이동할 때 가장 가까운 상어를 잡는다.
     * 모든 상어를 반사 이동시키고 같은 칸에서는 크기가 가장 큰 상어만 남긴다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        Shark[][] board = new Shark[rows][cols];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            Shark shark = new Shark(
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken())
            );

            board[shark.row][shark.col] = shark;
        }

        int answer = 0;

        for (int fisherCol = 0; fisherCol < cols; fisherCol++) {
            for (int row = 0; row < rows; row++) {
                if (board[row][fisherCol] != null) {
                    answer += board[row][fisherCol].size;
                    board[row][fisherCol] = null;
                    break;
                }
            }

            board = move(board, rows, cols);
        }

        System.out.print(answer);
    }

    static Shark[][] move(Shark[][] board, int rows, int cols) {
        Shark[][] next = new Shark[rows][cols];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int[] opposite = {1, 0, 3, 2};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Shark shark = board[row][col];

                if (shark == null) continue;

                int cycle = shark.direction < 2
                        ? Math.max(1, (rows - 1) * 2)
                        : Math.max(1, (cols - 1) * 2);

                int steps = shark.speed % cycle;
                int currentRow = shark.row;
                int currentCol = shark.col;
                int direction = shark.direction;

                for (int step = 0; step < steps; step++) {
                    int nr = currentRow + dr[direction];
                    int nc = currentCol + dc[direction];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                        direction = opposite[direction];
                        nr = currentRow + dr[direction];
                        nc = currentCol + dc[direction];
                    }

                    currentRow = nr;
                    currentCol = nc;
                }

                shark.row = currentRow;
                shark.col = currentCol;
                shark.direction = direction;

                if (next[currentRow][currentCol] == null
                        || next[currentRow][currentCol].size < shark.size) {
                    next[currentRow][currentCol] = shark;
                }
            }
        }

        return next;
    }
}
