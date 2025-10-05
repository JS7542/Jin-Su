import java.io.*;
import java.util.*;

class Main {
    /*
     * 시작 칸부터 BFS를 수행하며 처음 방문한 거리를 기록한다.
     * 각 칸은 최단 거리로 한 번만 방문되므로 도착 칸의 값이 정답이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n][m];

        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) maze[r][c] = line.charAt(c) - '0';
        }

        int[][] distance = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        distance[0][0] = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (maze[nr][nc] == 0 || distance[nr][nc] != 0) continue;

                distance[nr][nc] = distance[current[0]][current[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        System.out.print(distance[n - 1][m - 1]);
    }
}
