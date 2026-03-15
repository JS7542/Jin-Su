import java.io.*;
import java.util.*;

class Main {
    /*
     * 주사위를 현재 방향으로 굴리고 도착 칸과 바닥면 크기를 비교해 방향을 회전한다.
     * 각 칸의 같은 숫자 연결 요소 크기를 미리 구해 숫자×크기 점수를 누적한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int moves = Integer.parseInt(st.nextToken());

        int[][] board = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < cols; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] componentSize = calculateSizes(board);
        int[] dice = {1, 6, 3, 4, 2, 5};

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int row = 0;
        int col = 0;
        int direction = 0;
        int answer = 0;

        while (moves-- > 0) {
            int nr = row + dr[direction];
            int nc = col + dc[direction];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                direction = (direction + 2) % 4;
                nr = row + dr[direction];
                nc = col + dc[direction];
            }

            roll(dice, direction);
            row = nr;
            col = nc;

            answer += board[row][col] * componentSize[row][col];

            if (dice[1] > board[row][col]) {
                direction = (direction + 1) % 4;
            } else if (dice[1] < board[row][col]) {
                direction = (direction + 3) % 4;
            }
        }

        System.out.print(answer);
    }

    static int[][] calculateSizes(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] size = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col]) continue;

                List<int[]> cells = new ArrayList<>();
                Queue<int[]> queue = new ArrayDeque<>();

                queue.offer(new int[]{row, col});
                visited[row][col] = true;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    cells.add(current);

                    for (int direction = 0; direction < 4; direction++) {
                        int nr = current[0] + dr[direction];
                        int nc = current[1] + dc[direction];

                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                        if (visited[nr][nc]
                                || board[nr][nc] != board[row][col]) continue;

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                for (int[] cell : cells) {
                    size[cell[0]][cell[1]] = cells.size();
                }
            }
        }

        return size;
    }

    static void roll(int[] dice, int direction) {
        int top = dice[0];
        int bottom = dice[1];
        int east = dice[2];
        int west = dice[3];
        int north = dice[4];
        int south = dice[5];

        if (direction == 0) {
            dice[0] = west;
            dice[1] = east;
            dice[2] = top;
            dice[3] = bottom;
        } else if (direction == 1) {
            dice[0] = north;
            dice[1] = south;
            dice[4] = bottom;
            dice[5] = top;
        } else if (direction == 2) {
            dice[0] = east;
            dice[1] = west;
            dice[2] = bottom;
            dice[3] = top;
        } else {
            dice[0] = south;
            dice[1] = north;
            dice[4] = top;
            dice[5] = bottom;
        }
    }
}
