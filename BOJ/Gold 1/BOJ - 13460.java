import java.io.*;
import java.util.*;

class Main {
    static int rows;
    static int cols;
    static char[][] board;

    /*
     * 빨간 구슬과 파란 구슬 위치를 하나의 BFS 상태로 관리한다.
     * 네 방향으로 벽까지 굴리고 파란 구슬은 빠지지 않으면서 빨간 구슬만 빠지는 최소 횟수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        board = new char[rows][cols];

        int redRow = 0;
        int redCol = 0;
        int blueRow = 0;
        int blueCol = 0;

        for (int row = 0; row < rows; row++) {
            board[row] = br.readLine().toCharArray();

            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'R') {
                    redRow = row;
                    redCol = col;
                    board[row][col] = '.';
                } else if (board[row][col] == 'B') {
                    blueRow = row;
                    blueCol = col;
                    board[row][col] = '.';
                }
            }
        }

        boolean[][][][] visited = new boolean[
                rows][cols][rows][cols
        ];

        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(redRow, redCol, blueRow, blueCol, 0));
        visited[redRow][redCol][blueRow][blueCol] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.moves >= 10) continue;

            for (int direction = 0; direction < 4; direction++) {
                Move red = roll(
                        current.redRow,
                        current.redCol,
                        dr[direction],
                        dc[direction]
                );
                Move blue = roll(
                        current.blueRow,
                        current.blueCol,
                        dr[direction],
                        dc[direction]
                );

                if (blue.hole) continue;

                if (red.hole) {
                    System.out.print(current.moves + 1);
                    return;
                }

                if (red.row == blue.row && red.col == blue.col) {
                    if (red.distance > blue.distance) {
                        red.row -= dr[direction];
                        red.col -= dc[direction];
                    } else {
                        blue.row -= dr[direction];
                        blue.col -= dc[direction];
                    }
                }

                if (visited[red.row][red.col][blue.row][blue.col]) continue;

                visited[red.row][red.col][blue.row][blue.col] = true;
                queue.offer(new State(
                        red.row,
                        red.col,
                        blue.row,
                        blue.col,
                        current.moves + 1
                ));
            }
        }

        System.out.print(-1);
    }

    static Move roll(int row, int col, int dr, int dc) {
        int distance = 0;

        while (board[row + dr][col + dc] != '#') {
            row += dr;
            col += dc;
            distance++;

            if (board[row][col] == 'O') return new Move(row, col, distance, true);
        }

        return new Move(row, col, distance, false);
    }

    static class State {
        int redRow;
        int redCol;
        int blueRow;
        int blueCol;
        int moves;

        State(
                int redRow,
                int redCol,
                int blueRow,
                int blueCol,
                int moves
        ) {
            this.redRow = redRow;
            this.redCol = redCol;
            this.blueRow = blueRow;
            this.blueCol = blueCol;
            this.moves = moves;
        }
    }

    static class Move {
        int row;
        int col;
        int distance;
        boolean hole;

        Move(int row, int col, int distance, boolean hole) {
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.hole = hole;
        }
    }
}
