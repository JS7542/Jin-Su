import java.io.*;
import java.util.*;

class Main {
    /*
     * 시작 위치에서 6방향으로 이동하는 3차원 BFS를 수행한다.
     * 출구를 처음 방문한 시간이 최소 탈출 시간이며, 불가능하면 Trapped를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int[] dz = {-1, 1, 0, 0, 0, 0};
        int[] dr = {0, 0, -1, 1, 0, 0};
        int[] dc = {0, 0, 0, 0, -1, 1};

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int levels = Integer.parseInt(st.nextToken());
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());

            if (levels == 0 && rows == 0 && cols == 0) break;

            char[][][] building = new char[levels][rows][cols];
            int[] start = null;

            for (int z = 0; z < levels; z++) {
                for (int r = 0; r < rows; r++) {
                    building[z][r] = br.readLine().toCharArray();

                    for (int c = 0; c < cols; c++) {
                        if (building[z][r][c] == 'S') start = new int[]{z, r, c};
                    }
                }
                br.readLine();
            }

            int[][][] distance = new int[levels][rows][cols];
            for (int[][] level : distance) for (int[] row : level) Arrays.fill(row, -1);

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(start);
            distance[start[0]][start[1]][start[2]] = 0;
            int answer = -1;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int z = current[0];
                int r = current[1];
                int c = current[2];

                if (building[z][r][c] == 'E') {
                    answer = distance[z][r][c];
                    break;
                }

                for (int d = 0; d < 6; d++) {
                    int nz = z + dz[d];
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nz < 0 || nz >= levels || nr < 0 || nr >= rows
                            || nc < 0 || nc >= cols) continue;
                    if (building[nz][nr][nc] == '#' || distance[nz][nr][nc] != -1) continue;

                    distance[nz][nr][nc] = distance[z][r][c] + 1;
                    queue.offer(new int[]{nz, nr, nc});
                }
            }

            if (answer == -1) output.append("Trapped!\n");
            else output.append("Escaped in ").append(answer).append(" minute(s).\n");
        }

        System.out.print(output);
    }
}
