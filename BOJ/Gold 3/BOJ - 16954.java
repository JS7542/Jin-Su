import java.io.*;
import java.util.*;

class Main {
    /*
     * 욱제의 위치와 시간을 BFS 상태로 사용한다.
     * 이동 전과 이동 후 시점 모두에서 벽과 겹치지 않는 아홉 가지 이동을 탐색한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[8][];

        for (int row = 0; row < 8; row++) board[row] = br.readLine().toCharArray();

        boolean[][][] visited = new boolean[9][8][8];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{7, 0, 0});
        visited[0][7][0] = true;

        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];

            if (row == 0 && col == 7 || time >= 8) {
                System.out.print(1);
                return;
            }

            for (int d = 0; d < 9; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];
                int nextTime = Math.min(8, time + 1);

                if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8) continue;
                if (wall(board, nr, nc, time) || wall(board, nr, nc, time + 1)) continue;
                if (visited[nextTime][nr][nc]) continue;

                visited[nextTime][nr][nc] = true;
                queue.offer(new int[]{nr, nc, nextTime});
            }
        }

        System.out.print(0);
    }

    private static boolean wall(char[][] board, int row, int col, int time) {
        int originalRow = row - time;

        return originalRow >= 0
                && originalRow < 8
                && board[originalRow][col] == '#';
    }
}
