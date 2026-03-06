import java.io.*;
import java.util.*;

class Main {
    /*
     * 위치와 사용한 말 이동 횟수를 BFS 상태로 둔다.
     * 일반 네 방향 이동과 K번 이하의 말 이동을 함께 탐색해 최단 거리를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cols = Integer.parseInt(st.nextToken());
        int rows = Integer.parseInt(st.nextToken());

        int[][] map = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < cols; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] distance = new int[rows][cols][limit + 1];
        for (int[][] row : distance) {
            for (int[] cell : row) Arrays.fill(cell, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        distance[0][0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int[] horseR = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] horseC = {-1, 1, -2, 2, -2, 2, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int used = current[2];

            if (row == rows - 1 && col == cols - 1) {
                System.out.print(distance[row][col][used]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (map[nr][nc] == 1 || distance[nr][nc][used] != -1) continue;

                distance[nr][nc][used] = distance[row][col][used] + 1;
                queue.offer(new int[]{nr, nc, used});
            }

            if (used < limit) {
                for (int d = 0; d < 8; d++) {
                    int nr = row + horseR[d];
                    int nc = col + horseC[d];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (map[nr][nc] == 1 || distance[nr][nc][used + 1] != -1) continue;

                    distance[nr][nc][used + 1] = distance[row][col][used] + 1;
                    queue.offer(new int[]{nr, nc, used + 1});
                }
            }
        }

        System.out.print(-1);
    }
}
