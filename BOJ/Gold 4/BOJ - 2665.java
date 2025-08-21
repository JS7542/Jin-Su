import java.io.*;
import java.util.*;

class Main {
    /*
     * 흰 방 이동 비용은 0, 검은 방을 바꾸는 비용은 1로 두어 0-1 BFS를 수행한다.
     * 비용 0 이동은 덱 앞에, 비용 1 이동은 덱 뒤에 넣어 최소 변경 수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][];
        for (int row = 0; row < n; row++) map[row] = br.readLine().toCharArray();

        int[][] distance = new int[n][n];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        distance[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int cost = map[nr][nc] == '1' ? 0 : 1;
                int nextDistance = distance[current[0]][current[1]] + cost;

                if (nextDistance >= distance[nr][nc]) continue;

                distance[nr][nc] = nextDistance;

                if (cost == 0) deque.offerFirst(new int[]{nr, nc});
                else deque.offerLast(new int[]{nr, nc});
            }
        }

        System.out.print(distance[n - 1][n - 1]);
    }
}
