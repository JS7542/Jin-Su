import java.io.*;
import java.util.*;

class Main {
    /*
     * 위치와 지금까지 부순 벽 개수를 BFS 상태로 사용한다.
     * 빈 칸은 그대로 이동하고 벽은 K개 미만을 부쉈을 때만 다음 상태로 이동한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        char[][] map = new char[rows][];
        for (int row = 0; row < rows; row++) map[row] = br.readLine().toCharArray();

        int[][][] distance = new int[rows][cols][limit + 1];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0, 0});
        distance[0][0][0] = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int broken = current[2];

            if (row == rows - 1 && col == cols - 1) {
                System.out.print(distance[row][col][broken]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                int nextBroken = broken + (map[nr][nc] == '1' ? 1 : 0);

                if (nextBroken > limit || distance[nr][nc][nextBroken] != 0) continue;

                distance[nr][nc][nextBroken] = distance[row][col][broken] + 1;
                queue.offer(new int[]{nr, nc, nextBroken});
            }
        }

        System.out.print(-1);
    }
}
