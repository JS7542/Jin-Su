import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 칸의 루피를 이동 비용으로 보고 다익스트라 알고리즘을 수행한다.
     * 시작 칸 비용을 포함해 오른쪽 아래 칸까지 잃는 최소 루피를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int problem = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int[][] cave = new int[n][n];

            for (int row = 0; row < n; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < n; col++) {
                    cave[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] distance = new int[n][n];

            for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

            PriorityQueue<int[]> queue = new PriorityQueue<>(
                    Comparator.comparingInt(state -> state[2])
            );

            distance[0][0] = cave[0][0];
            queue.offer(new int[]{0, 0, cave[0][0]});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int cost = current[2];

                if (cost != distance[row][col]) continue;

                for (int direction = 0; direction < 4; direction++) {
                    int nr = row + dr[direction];
                    int nc = col + dc[direction];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                    int nextCost = cost + cave[nr][nc];

                    if (nextCost < distance[nr][nc]) {
                        distance[nr][nc] = nextCost;
                        queue.offer(new int[]{nr, nc, nextCost});
                    }
                }
            }

            output.append("Problem ").append(problem++)
                    .append(": ").append(distance[n - 1][n - 1]).append('\n');
        }

        System.out.print(output);
    }
}
