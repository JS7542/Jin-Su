import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 섬을 BFS로 번호 매긴 뒤 모든 육지 칸을 동시에 바다로 확장한다.
     * 서로 다른 섬의 확장 영역이 만날 때 두 거리 합의 최솟값이 가장 짧은 다리다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < n; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int island = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (map[row][col] != 1) continue;

                island++;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{row, col});
                map[row][col] = island + 1;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = current[0] + dr[d];
                        int nc = current[1] + dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                        if (map[nr][nc] != 1) continue;

                        map[nr][nc] = island + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        int[][] owner = new int[n][n];
        int[][] distance = new int[n][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (map[row][col] > 1) {
                    owner[row][col] = map[row][col];
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                if (owner[nr][nc] == 0) {
                    owner[nr][nc] = owner[current[0]][current[1]];
                    distance[nr][nc] = distance[current[0]][current[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                } else if (owner[nr][nc] != owner[current[0]][current[1]]) {
                    answer = Math.min(
                            answer,
                            distance[nr][nc] + distance[current[0]][current[1]]
                    );
                }
            }
        }

        System.out.print(answer);
    }
}
