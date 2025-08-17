import java.io.*;
import java.util.*;

class Solution {
    static int shots;
    static int width;
    static int height;
    static int answer;
    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};

    /*
     * 각 구슬을 떨어뜨릴 열의 모든 순서를 백트래킹한다.
     * 맞은 벽돌의 숫자 범위만큼 연쇄 폭발시킨 뒤 중력으로 벽돌을 내리고 남은 수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            shots = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            int[][] board = new int[height][width];

            for (int row = 0; row < height; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < width; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            answer = Integer.MAX_VALUE;
            search(0, board);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(int depth, int[][] board) {
        int remaining = count(board);
        answer = Math.min(answer, remaining);

        if (depth == shots || remaining == 0) return;

        for (int col = 0; col < width; col++) {
            int row = 0;

            while (row < height && board[row][col] == 0) row++;

            if (row == height) {
                search(depth + 1, board);
                continue;
            }

            int[][] next = copy(board);
            explode(next, row, col);
            gravity(next);
            search(depth + 1, next);
        }
    }

    static void explode(int[][] board, int startRow, int startCol) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol, board[startRow][startCol]});
        board[startRow][startCol] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                for (int distance = 1; distance < current[2]; distance++) {
                    int nr = current[0] + DR[direction] * distance;
                    int nc = current[1] + DC[direction] * distance;

                    if (nr < 0 || nr >= height || nc < 0 || nc >= width) continue;
                    if (board[nr][nc] == 0) continue;

                    int power = board[nr][nc];
                    board[nr][nc] = 0;

                    if (power > 1) queue.offer(new int[]{nr, nc, power});
                }
            }
        }
    }

    static void gravity(int[][] board) {
        for (int col = 0; col < width; col++) {
            int write = height - 1;

            for (int row = height - 1; row >= 0; row--) {
                if (board[row][col] == 0) continue;

                int value = board[row][col];
                board[row][col] = 0;
                board[write--][col] = value;
            }
        }
    }

    static int count(int[][] board) {
        int count = 0;

        for (int[] row : board) {
            for (int value : row) {
                if (value > 0) count++;
            }
        }

        return count;
    }

    static int[][] copy(int[][] board) {
        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) result[row] = board[row].clone();

        return result;
    }
}
