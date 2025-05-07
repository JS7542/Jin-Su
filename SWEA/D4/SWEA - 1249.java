import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 칸의 복구 시간을 이동 비용으로 보고 다익스트라 알고리즘을 수행한다.
     * 시작점에서 오른쪽 아래 칸까지 누적 복구 시간의 최솟값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];

            for (int row = 0; row < n; row++) {
                String line = br.readLine();

                for (int col = 0; col < n; col++) {
                    map[row][col] = line.charAt(col) - '0';
                }
            }

            int[][] distance = new int[n][n];

            for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

            PriorityQueue<int[]> queue = new PriorityQueue<>(
                    Comparator.comparingInt(state -> state[2])
            );

            distance[0][0] = 0;
            queue.offer(new int[]{0, 0, 0});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int cost = current[2];

                if (cost != distance[row][col]) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = row + dr[d];
                    int nc = col + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                    int nextCost = cost + map[nr][nc];

                    if (nextCost < distance[nr][nc]) {
                        distance[nr][nc] = nextCost;
                        queue.offer(new int[]{nr, nc, nextCost});
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(distance[n - 1][n - 1]).append('\n');
        }

        System.out.print(output);
    }
}
