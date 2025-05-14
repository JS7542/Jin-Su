import java.io.*;
import java.util.*;

class Main {
    /*
     * 위치와 벽을 부쉈는지 여부를 함께 BFS 상태로 관리한다.
     * 벽을 만나면 아직 부수지 않은 상태에서만 부순 상태로 이동한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        int[][][] distance = new int[n][m][2];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        distance[0][0][0] = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int broken = current[2];

            if (r == n - 1 && c == m - 1) {
                System.out.print(distance[r][c][broken]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                if (map[nr][nc] == '0' && distance[nr][nc][broken] == 0) {
                    distance[nr][nc][broken] = distance[r][c][broken] + 1;
                    queue.offer(new int[]{nr, nc, broken});
                } else if (map[nr][nc] == '1' && broken == 0
                        && distance[nr][nc][1] == 0) {
                    distance[nr][nc][1] = distance[r][c][0] + 1;
                    queue.offer(new int[]{nr, nc, 1});
                }
            }
        }

        System.out.print(-1);
    }
}
